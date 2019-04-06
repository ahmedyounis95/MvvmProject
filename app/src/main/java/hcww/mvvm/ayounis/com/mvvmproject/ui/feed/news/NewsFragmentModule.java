package hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news;

import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Ahmed Younis on 28/03/19.
 */
@Module
public class NewsFragmentModule {

    @Provides
    LinearLayoutManager provideLinearLayoutManager(NewsFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }

    @Provides
    NewsAdapter provideNewsAdapter() {
        return new NewsAdapter();
    }

}
