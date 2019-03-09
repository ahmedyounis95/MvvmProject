package hcww.mvvm.ayounis.com.mvvmproject.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import hcww.mvvm.ayounis.com.mvvmproject.MvvmApp;
import hcww.mvvm.ayounis.com.mvvmproject.di.ApplicationContext;
import hcww.mvvm.ayounis.com.mvvmproject.di.builder.ActivityBuilder;
import hcww.mvvm.ayounis.com.mvvmproject.di.module.AppModule;
import hcww.mvvm.ayounis.com.mvvmproject.di.module.NetModule;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AndroidInjectionModule.class,AppModule.class, NetModule.class,ActivityBuilder.class})
public interface AppComponent {

    void inject(MvvmApp app);

    @ApplicationContext
    Context context();

    Retrofit getRetrofit();

}
