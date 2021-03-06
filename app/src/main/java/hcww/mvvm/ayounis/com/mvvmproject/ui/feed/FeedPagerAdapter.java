package hcww.mvvm.ayounis.com.mvvmproject.ui.feed;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news.NewsFragment;

/**
 * Created by Ahmed Younis on 18/03/19.
 */

public class FeedPagerAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;

    public FeedPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 0;
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NewsFragment.newInstance();
            case 1:
                return NewsFragment.newInstance();
            default:
                return null;
        }
    }
}
