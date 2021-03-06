package hcww.mvvm.ayounis.com.mvvmproject.data.remote;

import hcww.mvvm.ayounis.com.mvvmproject.data.model.HomeData;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiHelper {

    @GET("v2/everything")
    Single<HomeData> getHomeData(@Query("apikey") String apiKey,
                                 @Query("q") String query,
                                 @Query("grouped") String groupBy,
                                 @Query("page") int page,
                                 @Query("source") String source,
                                 @Query("language") String language);


}
