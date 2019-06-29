package hcww.mvvm.ayounis.com.mvvmproject.data.remote;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import hcww.mvvm.ayounis.com.mvvmproject.MvvmApp;
import hcww.mvvm.ayounis.com.mvvmproject.data.model.HomeData;
import hcww.mvvm.ayounis.com.mvvmproject.di.ApplicationContext;
import io.reactivex.Single;
import retrofit2.Retrofit;

@Singleton
public class AppApiHelper implements ApiHelper {

    private Context mContext;
    private Retrofit retrofit;

    @Inject
    public AppApiHelper(@ApplicationContext Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Single<HomeData> getHomeData(String apiKey, String query, String groupBy, int page, String source, String language) {
        retrofit = ((MvvmApp)mContext).getComponent().getRetrofit();
        return retrofit.create(ApiHelper.class).getHomeData(apiKey,query,groupBy,page,source,language);
    }
}
