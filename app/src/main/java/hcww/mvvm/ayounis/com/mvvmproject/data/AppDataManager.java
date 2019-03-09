package hcww.mvvm.ayounis.com.mvvmproject.data;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import hcww.mvvm.ayounis.com.mvvmproject.data.model.HomeData;
import hcww.mvvm.ayounis.com.mvvmproject.data.remote.ApiHelper;
import hcww.mvvm.ayounis.com.mvvmproject.di.ApplicationContext;
import retrofit2.Call;


@Singleton
public class AppDataManager implements DataManager {
    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final ApiHelper mApiHelper;
//    private final AppDbHelper mAppDbHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, ApiHelper apiHelper){
        mContext = context;
        mApiHelper = apiHelper;
    }



    @Override
    public Call<HomeData> getHomeData(String apiKey, String query, String groupBy, int page, String source, String language) {
        return mApiHelper.getHomeData(apiKey,query,groupBy,page,source,language);
    }

}
