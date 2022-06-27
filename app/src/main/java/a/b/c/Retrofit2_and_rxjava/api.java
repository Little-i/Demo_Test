package a.b.c.Retrofit2_and_rxjava;

import android.database.Observable;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface api {
    @GET(" ")
    Call<ResponseBody> getData();

    @POST(" ")
    Call<ResponseBody> getPostData();

    @GET("top250")
    Observable<ResponseBody> getTopMovie(@Query("start") int start, @Query("count") int count);
}
