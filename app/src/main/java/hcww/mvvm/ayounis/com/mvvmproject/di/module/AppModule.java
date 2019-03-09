package hcww.mvvm.ayounis.com.mvvmproject.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hcww.mvvm.ayounis.com.mvvmproject.data.AppDataManager;
import hcww.mvvm.ayounis.com.mvvmproject.data.DataManager;
import hcww.mvvm.ayounis.com.mvvmproject.data.remote.ApiHelper;
import hcww.mvvm.ayounis.com.mvvmproject.data.remote.AppApiHelper;
import hcww.mvvm.ayounis.com.mvvmproject.di.ApplicationContext;
import hcww.mvvm.ayounis.com.mvvmproject.utils.AppConstants;
import hcww.mvvm.ayounis.com.mvvmproject.utils.rx.AppSchedulerProvider;
import hcww.mvvm.ayounis.com.mvvmproject.utils.rx.SchedulerProvider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }


    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

}
