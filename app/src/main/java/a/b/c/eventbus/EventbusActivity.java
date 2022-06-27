package a.b.c.eventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import a.b.c.R;
import a.b.c.lottie.LottieActivity;

public class EventbusActivity extends AppCompatActivity {
    private static final String TAG = "EventbusActivity: ";
    private TextView mTvEventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);

        Button mBtnSendEventBusMessage = findViewById(R.id.btn_EventBus_Demo);
        mBtnSendEventBusMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventbusActivity.this, LottieActivity.class));
            }
        });
        mTvEventBus = findViewById(R.id.tv_eventbus_getData);
        EventBus.getDefault().register(this);
        eventBusMessage(new MyMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventBusMessage(MyMessage myMessage){
        String message = myMessage.getMessage();
        mTvEventBus.setText(message);
        Log.d(TAG, "eventBusMessage: EventBus的数据：" + message);
    }
}