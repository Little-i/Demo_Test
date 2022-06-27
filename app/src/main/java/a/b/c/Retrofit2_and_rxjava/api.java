package a.b.c.Retrofit2_and_rxjava;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<ResponseBody>> listRepos(@Path("user") String user);
}
