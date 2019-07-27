package hcww.mvvm.ayounis.com.mvvmproject.di.module;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hcww.mvvm.ayounis.com.mvvmproject.data.AppDataManager;
import hcww.mvvm.ayounis.com.mvvmproject.data.DataManager;
import hcww.mvvm.ayounis.com.mvvmproject.data.local.db.AppDatabase;
import hcww.mvvm.ayounis.com.mvvmproject.data.local.db.AppDbHelper;
import hcww.mvvm.ayounis.com.mvvmproject.data.local.db.DbHelper;
import hcww.mvvm.ayounis.com.mvvmproject.data.remote.ApiHelper;
import hcww.mvvm.ayounis.com.mvvmproject.data.remote.AppApiHelper;
import hcww.mvvm.ayounis.com.mvvmproject.di.DatabaseInfo;
import hcww.mvvm.ayounis.com.mvvmproject.utils.AppConstants;
import hcww.mvvm.ayounis.com.mvvmproject.utils.rx.AppSchedulerProvider;
import hcww.mvvm.ayounis.com.mvvmproject.utils.rx.SchedulerProvider;

@Module
public class AppModule {

//    private final Application mApplication;

//    public AppModule(Application mApplication) {
//        this.mApplication = mApplication;
//    }


//    @Provides
//    @ApplicationContext
//    Context provideContext() {
//        return mApplication;
//    }
//
    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName,  Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }
    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
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
