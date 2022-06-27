package a.b.c.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import a.b.c.R;

/*
    关于Android raw和assets目录；https://blog.csdn.net/weixin_32744285/article/details/117319102
    demo参考来自：https://blog.csdn.net/Android_xiong_st/article/details/53129256
 */
public class GlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        ImageView mIvAssetsLoad = findViewById(R.id.iv_assetsLoad);
        ImageView mIvHttpLoad = findViewById(R.id.iv_httpLoad);
        ImageView mIvTest = findViewById(R.id.iv_test);
        Glide.with(this).load("file:///android_asset/pic1.jpg").into(mIvAssetsLoad);
        Glide.with(this).load("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png").into(mIvHttpLoad);
//        Glide.with(this).load("file://android_asset/pic1.jpg").asBitmap()
//        Bitmap bitmap = BitmapFactory.decodeFile("android.resource://" + getPackageName() + "raw/" + R.raw.pic2);
//        mIvTest.setImageBitmap(bitmap);//无法显示
    }
}