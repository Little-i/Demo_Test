package a.b.c.Retrofit2_and_rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.util.List;

import a.b.c.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
    retrofit整合rxjava参考自：https://www.jianshu.com/p/05d942e4bb27
 */
public class Retrofit2_RxjavaActivity extends AppCompatActivity {

    private static final String TAG = "RxJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit2_rxjava);

        TextView mTvTest = findViewById(R.id.tv_test);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api service = retrofit.create(api.class);
        /*
        Call<ResponseBody> call = service.getData();
//        Call<ResponseBody> call = service.getPostData();
//        Call<ResponseBody> call = service.getTopMovie(0,10);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
                    Log.d("111", "onResponse: success");
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (response.body() != null){
                                mTvTest.setText(response.body().string());
                            }else {
                                mTvTest.setText("null");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
         */
        /*
        service.getTopMovie(0, 10).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: 整合连接开始");
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            if (responseBody.string().equals("")) {
                                mTvTest.setText("返回空值");
                                Log.d(TAG, "onNext: 返回空值");
                            }
                            Log.d(TAG, "onNext: 对事件做出响应" + responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: 整合连接Complete");
                    }
                });
         */

        //RxJava实例
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: 开始连接");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "对next事件" + integer + "做出响应");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: 对error事件做出响应");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: 对Complete事件做出响应");
            }
        });
    }
}