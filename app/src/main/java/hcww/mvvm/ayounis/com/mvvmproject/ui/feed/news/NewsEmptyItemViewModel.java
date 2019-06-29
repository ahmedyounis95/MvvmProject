package hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news;

/**
 * Created by Ahmed Younis on 28/03/19.
 */

public class NewsEmptyItemViewModel {

    private final NewsEmptyItemViewModelListener mListener;

    public NewsEmptyItemViewModel(NewsEmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface NewsEmptyItemViewModelListener {

        void onRetryClick();
    }
}
