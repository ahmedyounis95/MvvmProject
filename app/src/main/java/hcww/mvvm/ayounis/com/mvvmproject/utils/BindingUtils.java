package hcww.mvvm.ayounis.com.mvvmproject.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import hcww.mvvm.ayounis.com.mvvmproject.data.model.Articles;
import hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news.NewsAdapter;
import hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news.NewsItemViewModel;

/**
 * Created by Ahmed Younis on 12/30/2018.
 */
public final class BindingUtils {
    private BindingUtils(){

    }

    @BindingAdapter({"adapter"})
    public static void addNewsItems(RecyclerView recyclerView, List<Articles> news) {
        NewsAdapter adapter = (NewsAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(news);
        }
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }

}
