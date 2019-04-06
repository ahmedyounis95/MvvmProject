package hcww.mvvm.ayounis.com.mvvmproject.ui.splash;

import hcww.mvvm.ayounis.com.mvvmproject.data.DataManager;
import hcww.mvvm.ayounis.com.mvvmproject.ui.base.BaseViewModel;
import hcww.mvvm.ayounis.com.mvvmproject.utils.rx.SchedulerProvider;

/**
 * Created by Ahmed Younis on 1/25/2019.
 */
public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public SplashViewModel(DataManager mDataManager, SchedulerProvider mSchedulerProvider) {
        super(mDataManager, mSchedulerProvider);
    }

    public void decideNextActivity(){
        getNavigator().openMainActivity();
    }
}
