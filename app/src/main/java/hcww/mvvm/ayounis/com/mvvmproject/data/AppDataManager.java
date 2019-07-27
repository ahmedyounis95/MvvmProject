package hcww.mvvm.ayounis.com.mvvmproject.data;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import hcww.mvvm.ayounis.com.mvvmproject.data.local.db.DbHelper;
import hcww.mvvm.ayounis.com.mvvmproject.data.model.Articles;
import hcww.mvvm.ayounis.com.mvvmproject.data.model.HomeData;
import hcww.mvvm.ayounis.com.mvvmproject.data.remote.ApiHelper;
import hcww.mvvm.ayounis.com.mvvmproject.di.ApplicationContext;
import io.reactivex.Observable;
import io.reactivex.Single;


@Singleton
public class AppDataManager implements DataManager {
    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final ApiHelper mApiHelper;
    private final DbHelper mDbHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, ApiHelper apiHelper, DbHelper DbHelper){
        mContext = context;
        mApiHelper = apiHelper;
        mDbHelper = DbHelper;
    }



    @Override
    public Single<HomeData> getHomeData(String apiKey, String query, String groupBy, int page, String source, String language) {
        return mApiHelper.getHomeData(apiKey,query,groupBy,page,source,language);
    }

    @Override
    public Observable<List<Articles>> getAllArticles() {
        return mDbHelper.getAllArticles();
    }
}
