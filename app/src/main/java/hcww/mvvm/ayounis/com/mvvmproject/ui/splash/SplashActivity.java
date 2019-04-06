package hcww.mvvm.ayounis.com.mvvmproject.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;
import androidx.annotation.Nullable;

import androidx.lifecycle.ViewModelProviders;
import hcww.mvvm.ayounis.com.mvvmproject.BR;
import hcww.mvvm.ayounis.com.mvvmproject.R;
import hcww.mvvm.ayounis.com.mvvmproject.ViewModelProviderFactory;
import hcww.mvvm.ayounis.com.mvvmproject.databinding.ActivitySplashBinding;
import hcww.mvvm.ayounis.com.mvvmproject.ui.base.BaseActivity;
import hcww.mvvm.ayounis.com.mvvmproject.ui.feed.FeedActivity;

/**
 * Created by Ahmed Younis on 1/25/2019.
 */
public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashViewModel> implements SplashNavigator {

    @Inject
    ViewModelProviderFactory factory;
    private SplashViewModel mSplashViewModel;

    public static Intent newIntent(Context context){
        return new Intent(context,SplashActivity.class);
    }
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        mSplashViewModel = ViewModelProviders.of(this,factory).get(SplashViewModel.class);
        return mSplashViewModel;
    }

    @Override
    public void openMainActivity() {
        Intent intent = FeedActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.decideNextActivity();
    }
}
