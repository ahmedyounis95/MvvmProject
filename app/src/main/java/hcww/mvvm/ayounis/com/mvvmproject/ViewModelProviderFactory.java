package hcww.mvvm.ayounis.com.mvvmproject;


import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import hcww.mvvm.ayounis.com.mvvmproject.data.DataManager;
import hcww.mvvm.ayounis.com.mvvmproject.ui.feed.FeedViewModel;
import hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news.NewsViewModel;
import hcww.mvvm.ayounis.com.mvvmproject.ui.splash.SplashViewModel;
import hcww.mvvm.ayounis.com.mvvmproject.utils.rx.SchedulerProvider;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory{

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager,
                                    SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(FeedViewModel.class)) {
            //noinspection unchecked
            return (T) new FeedViewModel(dataManager,schedulerProvider);
        }else if (modelClass.isAssignableFrom(NewsViewModel.class)) {
            //noinspection unchecked
            return (T) new NewsViewModel(dataManager,schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(SplashViewModel.class)) {
            //noinspection unchecked
            return (T) new SplashViewModel(dataManager,schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }


}
