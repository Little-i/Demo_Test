package a.b.c.resolve_address;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import a.b.c.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
    demo参考来自：https://blog.csdn.net/weixin_39802784/article/details/117349590
 */
public class ResolveAddressActivity extends AppCompatActivity {
    private TextView mTvParseXML;
    private RecyclerView mRvParseXMLTitles;
    private List<String> titlesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resolve_address);

        mTvParseXML = findViewById(R.id.tv_parse_xml_title);
        mRvParseXMLTitles = findViewById(R.id.rv_parse_xml_titles);
        mRvParseXMLTitles.setLayoutManager(new GridLayoutManager(this,1));
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                String url = "https://www.music-news.com/rss/UK/news?includeCover=true";
                Request request = new Request.Builder().url(url).build();
                try {
                    Response response = client.newCall(request).execute();
                    String result = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setTitleText(result);
                            mRvParseXMLTitles.setAdapter(new ParseXMLRecyclerViewAdapter(titlesList,ResolveAddressActivity.this));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void setTitleText(String result){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser pullParser = factory.newPullParser();
            pullParser.setInput(new StringReader(result));
            titlesList = new ArrayList<>();
            int type;
            type = pullParser.getEventType();
            while (type != XmlPullParser.END_DOCUMENT){
                String nodeName = pullParser.getName();
                switch (type){
                    case XmlPullParser.START_TAG:
                        if (nodeName.equals("title")){
                            titlesList.add(pullParser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                type = pullParser.next();
            }
            mTvParseXML.setText(titlesList.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}