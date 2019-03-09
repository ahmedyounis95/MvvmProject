package hcww.mvvm.ayounis.com.mvvmproject.ui.splash;

import dagger.Module;
import dagger.Provides;
import hcww.mvvm.ayounis.com.mvvmproject.data.DataManager;
import hcww.mvvm.ayounis.com.mvvmproject.utils.rx.SchedulerProvider;

/**
 * Created by Ahmed Younis on 1/25/2019.
 */
@Module
public class SplashActivityModule {
    @Provides
    SplashViewModel provideSplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new SplashViewModel(dataManager,schedulerProvider);
    }
}
