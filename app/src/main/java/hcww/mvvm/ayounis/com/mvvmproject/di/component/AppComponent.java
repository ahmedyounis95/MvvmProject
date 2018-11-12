package hcww.mvvm.ayounis.com.mvvmproject.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import hcww.mvvm.ayounis.com.mvvmproject.MvvmApp;
import hcww.mvvm.ayounis.com.mvvmproject.di.builder.ActivityBuilder;
import hcww.mvvm.ayounis.com.mvvmproject.di.module.AppModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,AppModule.class,ActivityBuilder.class})
public interface AppComponent {

    void inject(MvvmApp app);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
