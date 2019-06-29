package hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news;

import androidx.databinding.ObservableField;

import hcww.mvvm.ayounis.com.mvvmproject.data.model.Articles;
import hcww.mvvm.ayounis.com.mvvmproject.utils.CommonUtils;

/**
 * Created by Ahmed Younis on 28/03/19.
 */

public class NewsItemViewModel {

    public final ObservableField<String> description;

    public final ObservableField<String> imageUrl;

    public final ObservableField<String> publishedAt;

    public final ObservableField<String> title;

    public final ObservableField<String> author;

    public final NewsItemViewModelListener mListener;

    private final Articles mArticles;


    public NewsItemViewModel( Articles articles,NewsItemViewModelListener listener) {
        this.mListener =listener;
        this.mArticles = articles;
        this.imageUrl = new ObservableField<>(mArticles.getUrlToImage());
        this.title = new ObservableField<>(mArticles.getTitle());
        this.author = new ObservableField<>(mArticles.getAuthor());
        this.description = new ObservableField<>(mArticles.getDescription());

        this.publishedAt = new ObservableField<>(CommonUtils.getDate(mArticles.getPublishedAt()));
    }
    public void onItemClick() {
        mListener.onItemClick();
    }

    public interface NewsItemViewModelListener {

        void onItemClick();
    }
}
