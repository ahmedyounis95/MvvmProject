package hcww.mvvm.ayounis.com.mvvmproject.ui.feed;


import hcww.mvvm.ayounis.com.mvvmproject.data.DataManager;
import hcww.mvvm.ayounis.com.mvvmproject.ui.base.BaseViewModel;
import hcww.mvvm.ayounis.com.mvvmproject.utils.rx.SchedulerProvider;

/**
 * Created by Jyoti on 29/07/17.
 */

public class FeedViewModel extends BaseViewModel {

    public FeedViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
