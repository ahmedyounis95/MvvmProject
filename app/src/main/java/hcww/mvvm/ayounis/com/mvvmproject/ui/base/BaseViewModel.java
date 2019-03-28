package hcww.mvvm.ayounis.com.mvvmproject.ui.base;



import java.lang.ref.WeakReference;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;
import hcww.mvvm.ayounis.com.mvvmproject.data.DataManager;
import hcww.mvvm.ayounis.com.mvvmproject.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ahmed Younis on 1/2/2019.
 */
public abstract class BaseViewModel<N> extends ViewModel {

    private final DataManager mDataManager;

    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);

    private final SchedulerProvider mSchedulerProvider;

    private CompositeDisposable mCompositeDisposable;

    private WeakReference<N> mNavigator;

    public BaseViewModel(DataManager mDataManager, SchedulerProvider mSchedulerProvider) {
        this.mDataManager = mDataManager;
        this.mSchedulerProvider = mSchedulerProvider;
        this.mCompositeDisposable =new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable(){return mCompositeDisposable;}

    public DataManager getDataManager(){return mDataManager;}

    public ObservableBoolean getIsLoading(){return mIsLoading;}

    public void setIsLoading(boolean isLoading){mIsLoading.set(isLoading);}

    public N getNavigator(){return mNavigator.get();}

    public void setNavigator(N navigator){this.mNavigator = new WeakReference<>(navigator);}

    public SchedulerProvider getSchedulerProvider(){return mSchedulerProvider;}



}
