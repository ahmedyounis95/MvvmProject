package hcww.mvvm.ayounis.com.mvvmproject.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import hcww.mvvm.ayounis.com.mvvmproject.ui.feed.FeedActivity;
import hcww.mvvm.ayounis.com.mvvmproject.ui.feed.FeedActivityModule;
import hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news.NewsFragmentProvider;
import hcww.mvvm.ayounis.com.mvvmproject.ui.splash.SplashActivity;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            FeedActivityModule.class,
            NewsFragmentProvider.class})
    abstract FeedActivity bindFeedActivity();

    @ContributesAndroidInjector()
    abstract SplashActivity bindSplashActivity();

}
