package hcww.mvvm.ayounis.com.mvvmproject.ui.feed;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ahmed Younis on 18/03/19.
 */
@Module
public class FeedActivityModule {

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(FeedActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

}
