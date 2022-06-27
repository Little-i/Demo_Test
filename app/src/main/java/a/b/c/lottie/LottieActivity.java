package a.b.c.lottie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import a.b.c.R;
import a.b.c.eventbus.MyMessage;

/*
    demo参考来自：https://www.jianshu.com/p/ddc22b094bd6
 */
public class LottieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

//        LottieAnimationView mLtAnimView = findViewById(R.id.lt_lottie_test);
//        mLtAnimView.playAnimation();
        Button mBtnSendEventBusMessage = findViewById(R.id.btn_lottie_send_eventbus_message);
        mBtnSendEventBusMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyMessage myMessage = new MyMessage();
                myMessage.setMessage("这是EventBus发送的消息");
                EventBus.getDefault().post(myMessage);
                finish();
            }
        });
    }
}