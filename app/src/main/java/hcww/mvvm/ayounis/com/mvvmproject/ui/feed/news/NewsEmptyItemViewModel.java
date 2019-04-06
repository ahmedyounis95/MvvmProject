package hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news;

/**
 * Created by Ahmed Younis on 28/03/19.
 */

public class NewsEmptyItemViewModel {

    private final OpenSourceEmptyItemViewModelListener mListener;

    public NewsEmptyItemViewModel(OpenSourceEmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface OpenSourceEmptyItemViewModelListener {

        void onRetryClick();
    }
}
