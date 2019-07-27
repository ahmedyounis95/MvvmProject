package hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import hcww.mvvm.ayounis.com.mvvmproject.data.DataManager;
import hcww.mvvm.ayounis.com.mvvmproject.data.model.Articles;
import hcww.mvvm.ayounis.com.mvvmproject.ui.base.BaseViewModel;
import hcww.mvvm.ayounis.com.mvvmproject.utils.rx.SchedulerProvider;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Ahmed Younis on 28/03/19.
 */

public class NewsViewModel extends BaseViewModel<NewsNavigator> {

    private final MutableLiveData<List<Articles>> newsItemsLiveData;

    public NewsViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        newsItemsLiveData = new MutableLiveData<>();
        fetchRepos();
    }

    public void fetchRepos() {
        setIsLoading(true);

        getCompositeDisposable().add(getDataManager()
                .getHomeData("dcf37b3045e542df970986c1114eb3ea", "news", "day", 1, "USA Today", "en")
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(homeData -> {
                    if (homeData != null && homeData.getArticles()!= null) {

                        newsItemsLiveData.setValue(homeData.getArticles());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }
    public LiveData<List<Articles>> getNewsItemsLiveData() {
        return newsItemsLiveData;
    }
}
