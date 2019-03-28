package hcww.mvvm.ayounis.com.mvvmproject;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import hcww.mvvm.ayounis.com.mvvmproject.di.component.AppComponent;
import hcww.mvvm.ayounis.com.mvvmproject.di.component.DaggerAppComponent;
import hcww.mvvm.ayounis.com.mvvmproject.di.module.AppModule;
import hcww.mvvm.ayounis.com.mvvmproject.di.module.NetModule;
import hcww.mvvm.ayounis.com.mvvmproject.utils.AppConstants;
import hcww.mvvm.ayounis.com.mvvmproject.utils.AppLogger;

public class MvvmApp extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(AppConstants.BASE_URLS))
                .build();
        mAppComponent.inject(this);

        AppLogger.init();


    }

    public AppComponent getComponent() {
        return mAppComponent;
    }


}
