package hcww.mvvm.ayounis.com.mvvmproject.data.remote;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import hcww.mvvm.ayounis.com.mvvmproject.MvvmApp;
import hcww.mvvm.ayounis.com.mvvmproject.data.model.HomeData;
import io.reactivex.Single;
import retrofit2.Retrofit;

@Singleton
public class AppApiHelper implements ApiHelper {

    private Retrofit mRetrofit;

    @Inject
    public AppApiHelper(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

    @Override
    public Single<HomeData> getHomeData(String apiKey, String query, String groupBy, int page, String source, String language) {
        return mRetrofit.create(ApiHelper.class).getHomeData(apiKey,query,groupBy,page,source,language);
    }
}
