package a.b.c.Gson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import a.b.c.R;

public class GsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        TextView mTvGsonDemo = findViewById(R.id.tv_Gson_demo);
        String jsonData = "[{\"id\":\"1\",\"version\":\"1.0\",\"name\":\"shufu\"},\n" +
                "{\"id\":\"2\",\"version\":\"2.2\",\"name\":\"pangzi\"},\n" +
                "{\"id\":\"3\",\"version\":\"3.3\",\"name\":\"john\"}]";
        Reader reader = null;
        try {
            //TODO 这个文件路径应该写什么？
//            reader = new FileReader("...");
            InputStream test1 = getResources().openRawResource(R.raw.test1);
            reader = new InputStreamReader(test1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        if (reader != null){
            //如果是json字符串的话，直接把reader换成jsonData
            List<Student> studentList = gson.fromJson(reader, new TypeToken<List<Student>>() {
            }.getType());
            mTvGsonDemo.setText(studentList.toString());
            Log.d("TAG:", "onCreate: " + studentList);
        } else {
            mTvGsonDemo.setText("reader为空");
        }
    }
}