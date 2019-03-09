package hcww.mvvm.ayounis.com.mvvmproject.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import hcww.mvvm.ayounis.com.mvvmproject.BR;
import hcww.mvvm.ayounis.com.mvvmproject.R;
import hcww.mvvm.ayounis.com.mvvmproject.databinding.ActivitySplashBinding;
import hcww.mvvm.ayounis.com.mvvmproject.ui.base.BaseActivity;

/**
 * Created by Ahmed Younis on 1/25/2019.
 */
public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashViewModel> implements SplashNavigator {

    @Inject
    SplashViewModel mSplashViewModel;

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
        return mSplashViewModel;
    }

    @Override
    public void openMainActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.decideNextActivity();
    }
}
