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

    private final MutableLiveData<List<NewsItemViewModel>> newsItemsLiveData;

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
                .map(homeData -> homeData.getArticles())
                .flatMap(this::getViewModelList)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(newsItemViewModels -> {
                    newsItemsLiveData.setValue(newsItemViewModels);
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public LiveData<List<NewsItemViewModel>> getNewsItemsLiveData() {
        return newsItemsLiveData;
    }

    private Single<List<NewsItemViewModel>> getViewModelList(List<Articles> repoList) {
        return Observable.fromIterable(repoList)
                .map(repo -> new NewsItemViewModel(
                        repo.getUrlToImage(), repo.getDescription(),
                        repo.getTitle(),repo.getContent())).toList();
    }
}
