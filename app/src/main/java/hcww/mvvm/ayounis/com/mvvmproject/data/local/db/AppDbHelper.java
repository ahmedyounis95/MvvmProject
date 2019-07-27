package hcww.mvvm.ayounis.com.mvvmproject.data.local.db;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import hcww.mvvm.ayounis.com.mvvmproject.data.model.Articles;
import io.reactivex.Observable;

/**
 * Created by Ahmed Younis on 7/10/2019.
 */
public class AppDbHelper implements DbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase mAppDatabase) {
        this.mAppDatabase = mAppDatabase;
    }



    @Override
    public Observable<List<Articles>> getAllArticles() {
        return Observable.fromCallable(new Callable<List<Articles>>() {
            @Override
            public List<Articles> call() throws Exception {
                return mAppDatabase.NewsDao().getAllNews();
            }
        });
    }
}
