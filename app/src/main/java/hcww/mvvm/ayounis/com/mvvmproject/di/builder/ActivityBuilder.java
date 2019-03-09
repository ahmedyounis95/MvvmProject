package hcww.mvvm.ayounis.com.mvvmproject.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import hcww.mvvm.ayounis.com.mvvmproject.ui.splash.SplashActivity;
import hcww.mvvm.ayounis.com.mvvmproject.ui.splash.SplashActivityModule;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();
}
