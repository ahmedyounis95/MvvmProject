package hcww.mvvm.ayounis.com.mvvmproject;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import hcww.mvvm.ayounis.com.mvvmproject.di.component.DaggerAppComponent;
import hcww.mvvm.ayounis.com.mvvmproject.utils.AppConstants;
import hcww.mvvm.ayounis.com.mvvmproject.utils.AppLogger;

public class MvvmApp extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .baseUrl(AppConstants.BASE_URLS)
                .build()
                .inject(this);


        AppLogger.init();


    }

}
