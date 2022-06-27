package a.b.c.tourGuide;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Toast;

import a.b.c.R;
import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;

/*
    demo参考来自：https://blog.csdn.net/weixin_39981093/article/details/117750545
                https://zhuanlan.zhihu.com/p/33162069
 */
public class TourGuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide);

        Button mBtnTourGuide1 = findViewById(R.id.btn_tourGuide1);
        Button mBtnTourGuide2 = findViewById(R.id.btn_tourGuide2);
        Button mBtnTourGuide3 = findViewById(R.id.btn_tourGuide3);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(1000);
        TourGuide tourGuide = TourGuide.init(this).with(TourGuide.Technique.Click)
                .setPointer(new Pointer()
                        .setColor(Color.WHITE))
                .setToolTip(new ToolTip()
                        .setTitle("Button1")
                        .setDescription("请点击Button1")
                        .setTextColor(Color.parseColor("#bdc3c7"))
                        .setBackgroundColor(Color.parseColor("#e74c3c")).setShadow(true)
                        .setGravity(Gravity.TOP | Gravity.LEFT)
                        .setEnterAnimation(alphaAnimation))
                .setOverlay(new Overlay()
                        .setHoleRadius(200)
                        .disableClick(true))
                .playOn(mBtnTourGuide1);

        mBtnTourGuide1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tourGuide.cleanUp();
                tourGuide.setToolTip(new ToolTip()
                                .setTitle("Button2")
                                .setDescription("请点击Button2")
                                .setTextColor(Color.parseColor("#bdc3c7"))
                                .setBackgroundColor(Color.parseColor("#e74c3c")).setShadow(true)
                                .setGravity(Gravity.TOP)
                                .setEnterAnimation(alphaAnimation))
                        .playOn(mBtnTourGuide2);
            }
        });
        mBtnTourGuide2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tourGuide.cleanUp();
                tourGuide.setToolTip(new ToolTip()
                                .setTitle("Button3")
                                .setDescription("请点击Button3")
                                .setTextColor(Color.parseColor("#bdc3c7"))
                                .setBackgroundColor(Color.parseColor("#e74c3c")).setShadow(true)
                                .setGravity(Gravity.TOP | Gravity.RIGHT)
                                .setEnterAnimation(alphaAnimation))
                        .playOn(mBtnTourGuide3);
            }
        });
        mBtnTourGuide3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tourGuide.cleanUp();
                Toast.makeText(TourGuideActivity.this,"已完成点击引导",Toast.LENGTH_SHORT).show();
            }
        });
    }
}