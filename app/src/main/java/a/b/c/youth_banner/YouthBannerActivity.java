package a.b.c.youth_banner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.transformer.AlphaPageTransformer;
import com.youth.banner.transformer.RotateUpPageTransformer;
import com.youth.banner.transformer.RotateYTransformer;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;

import a.b.c.R;

/*
    Demo参考来自：https://blog.csdn.net/xhnmbest/article/details/106636503
 */
public class YouthBannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youth_banner);

        Banner banner = findViewById(R.id.banner_test_demo);
        ImageAdapter adapter = new ImageAdapter(DataBean.getImageData());
        banner.setAdapter(adapter).setCurrentItem(3,false)
                .addBannerLifecycleObserver(this)
                .setBannerRound(0)
                .addPageTransformer(new AlphaPageTransformer())
                .setIndicator(new CircleIndicator(this));
    }

    public class ImageAdapter extends BannerAdapter<DataBean,ImageAdapter.BannerViewHolder>{

        public ImageAdapter(List<DataBean> data) {
            super(data);
        }

        @Override
        public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
            ImageView imageView = new ImageView(parent.getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return new BannerViewHolder(imageView);
        }

        @Override
        public void onBindView(BannerViewHolder holder, DataBean data, int position, int size) {
            Glide.with(holder.imageView.getContext()).load(data.imageUrl).into(holder.imageView);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),"click"+position, Toast.LENGTH_SHORT).show();
                }
            });
        }

        public class BannerViewHolder extends RecyclerView.ViewHolder{
            private final ImageView imageView;

            public BannerViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = (ImageView) itemView;
            }
        }
    }
}