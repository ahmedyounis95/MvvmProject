package hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Ahmed Younis on 28/03/19.
 */
@Module
public abstract class NewsFragmentProvider {

    @ContributesAndroidInjector(modules = NewsFragmentModule.class)
    abstract NewsFragment provideNewsFragmentFactory();
}
