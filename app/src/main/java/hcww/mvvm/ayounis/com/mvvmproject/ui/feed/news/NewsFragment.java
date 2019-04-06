package hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news;

import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import hcww.mvvm.ayounis.com.mvvmproject.BR;
import hcww.mvvm.ayounis.com.mvvmproject.R;
import hcww.mvvm.ayounis.com.mvvmproject.ViewModelProviderFactory;
import hcww.mvvm.ayounis.com.mvvmproject.databinding.FragmentNewsBinding;
import hcww.mvvm.ayounis.com.mvvmproject.ui.base.BaseFragment;

/**
 * Created by Ahmed Younis on 3/28/2019.
 */
public class NewsFragment extends BaseFragment<FragmentNewsBinding,NewsViewModel>
        implements NewsNavigator, NewsAdapter.NewsAdapterListener {

    FragmentNewsBinding mFragmentNewsBinding;
    @Inject
    LinearLayoutManager mLayoutManager;
    @Inject
    NewsAdapter mNewsAdapter;
    @Inject
    ViewModelProviderFactory factory;
    private NewsViewModel mNewsViewModel;

    public static NewsFragment newInstance(){
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable(){return BR.viewModel;}

    @Override
    public int getLayoutId(){
        return R.layout.fragment_news;
    }

    @Override
    public NewsViewModel getViewModel() {
        mNewsViewModel = ViewModelProviders.of(this,factory).get(NewsViewModel.class);
        return mNewsViewModel;

    }

    @Override
    public void handleError(Throwable throwable){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNewsViewModel.setNavigator(this);
        mNewsAdapter.setListener(this);
    }

    @Override
    public void onRetryClick() {mNewsViewModel.fetchRepos(); }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentNewsBinding= getViewDataBinding();
        setUp();
    }
    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentNewsBinding.openSourceRecyclerView.setLayoutManager(mLayoutManager);
        mFragmentNewsBinding.openSourceRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFragmentNewsBinding.openSourceRecyclerView.setAdapter(mNewsAdapter);
    }
}
