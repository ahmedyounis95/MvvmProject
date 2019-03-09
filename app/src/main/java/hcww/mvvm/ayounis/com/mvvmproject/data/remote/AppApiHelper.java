package hcww.mvvm.ayounis.com.mvvmproject.data.remote;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import hcww.mvvm.ayounis.com.mvvmproject.MvvmApp;
import hcww.mvvm.ayounis.com.mvvmproject.data.model.HomeData;
import hcww.mvvm.ayounis.com.mvvmproject.di.ApplicationContext;
import retrofit2.Call;
import retrofit2.Retrofit;

@Singleton
public class AppApiHelper implements ApiHelper {

    private Context mContext;
    @Inject
    public AppApiHelper(@ApplicationContext Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Call<HomeData> getHomeData(String apiKey, String query, String groupBy, int page, String source, String language) {
        Context mContext = null;
        Retrofit retrofit = ((MvvmApp)mContext).getComponent().getRetrofit();
        return retrofit.create(ApiHelper.class).getHomeData(apiKey,query,groupBy,page,source,language);
    }
}
