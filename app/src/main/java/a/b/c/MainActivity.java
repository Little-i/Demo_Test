package a.b.c;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import a.b.c.Gson.GsonActivity;
import a.b.c.Retrofit2_and_rxjava.Retrofit2_RxjavaActivity;
import a.b.c.eventbus.EventbusActivity;
import a.b.c.glide.GlideActivity;
import a.b.c.lottie.LottieActivity;
import a.b.c.resolve_address.ResolveAddressActivity;
import a.b.c.youth_banner.YouthBannerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mBtnRetrofit2AndRxjava = findViewById(R.id.btn_Retrofit2_Rxjava);
        Button mBtnYouthBanner = findViewById(R.id.btn_youth_banner);
        Button mBtnResolveAddress = findViewById(R.id.btn_resolve_address);
        Button mBtnGlide = findViewById(R.id.btn_glide);
        Button mBtnLottie = findViewById(R.id.btn_lottie);
        Button mBtnGson = findViewById(R.id.btn_gson);
        Button mBtnEventBus = findViewById(R.id.btn_EventBus);
        mBtnRetrofit2AndRxjava.setOnClickListener(this);
        mBtnYouthBanner.setOnClickListener(this);
        mBtnResolveAddress.setOnClickListener(this);
        mBtnGlide.setOnClickListener(this);
        mBtnLottie.setOnClickListener(this);
        mBtnGson.setOnClickListener(this);
        mBtnEventBus.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_Retrofit2_Rxjava:
                startActivity(new Intent(this, Retrofit2_RxjavaActivity.class));
                break;
            case R.id.btn_youth_banner:
                startActivity(new Intent(this, YouthBannerActivity.class));
                break;
            case R.id.btn_resolve_address:
                startActivity(new Intent(this, ResolveAddressActivity.class));
                break;
            case R.id.btn_glide:
                startActivity(new Intent(this, GlideActivity.class));
                break;
            case R.id.btn_lottie:
                startActivity(new Intent(this, LottieActivity.class));
                break;
            case R.id.btn_gson:
                startActivity(new Intent(this, GsonActivity.class));
                break;
            case R.id.btn_EventBus:
                startActivity(new Intent(this, EventbusActivity.class));
                break;
        }
    }
}