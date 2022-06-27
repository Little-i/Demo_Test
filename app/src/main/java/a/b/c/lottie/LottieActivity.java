package a.b.c.lottie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;

import a.b.c.R;

/*
    demo参考来自：https://www.jianshu.com/p/ddc22b094bd6
 */
public class LottieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

        LottieAnimationView mLtAnimView = findViewById(R.id.lt_lottie_test);
        mLtAnimView.playAnimation();
    }
}