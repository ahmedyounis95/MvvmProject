package hcww.mvvm.ayounis.com.mvvmproject.di.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import hcww.mvvm.ayounis.com.mvvmproject.MvvmApp;
import hcww.mvvm.ayounis.com.mvvmproject.di.builder.ActivityBuilder;
import hcww.mvvm.ayounis.com.mvvmproject.di.module.AppModule;
import hcww.mvvm.ayounis.com.mvvmproject.di.module.NetModule;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,AppModule.class, NetModule.class,ActivityBuilder.class})
public interface AppComponent {

    void inject(MvvmApp app);

    Retrofit getRetrofit();
}
