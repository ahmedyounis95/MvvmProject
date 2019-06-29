package hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

import hcww.mvvm.ayounis.com.mvvmproject.data.model.Articles;
import hcww.mvvm.ayounis.com.mvvmproject.databinding.ItemNewsEmptyViewBinding;
import hcww.mvvm.ayounis.com.mvvmproject.databinding.ItemNewsViewBinding;
import hcww.mvvm.ayounis.com.mvvmproject.ui.base.BaseViewHolder;
import hcww.mvvm.ayounis.com.mvvmproject.utils.AppLogger;

/**
 * Created by Ahmed Younis on 28/03/19.
 */

public class NewsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private final List<Articles> mNewsResponseList;

    private NewsAdapterListener mListener;

    public NewsAdapter(List<Articles> newsResponseList) {
        this.mNewsResponseList = newsResponseList;
    }

    @Override
    public int getItemCount() {
        if (!mNewsResponseList.isEmpty()) {
            return mNewsResponseList.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (!mNewsResponseList.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemNewsViewBinding newsViewBinding = ItemNewsViewBinding
                        .inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new OpenSourceViewHolder(newsViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemNewsEmptyViewBinding emptyViewBinding = ItemNewsEmptyViewBinding
                        .inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new EmptyViewHolder(emptyViewBinding);
        }
    }

    public void addItems(List<Articles> repoList) {
        mNewsResponseList.addAll(repoList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mNewsResponseList.clear();
    }

    public void setListener(NewsAdapterListener listener) {
        this.mListener = listener;
    }

    public interface NewsAdapterListener {

        void onRetryClick();
    }

    public class EmptyViewHolder extends BaseViewHolder implements NewsEmptyItemViewModel.NewsEmptyItemViewModelListener {

        private final ItemNewsEmptyViewBinding mBinding;

        public EmptyViewHolder(ItemNewsEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            NewsEmptyItemViewModel emptyItemViewModel = new NewsEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }

        @Override
        public void onRetryClick() {
            mListener.onRetryClick();
        }
    }

    public class OpenSourceViewHolder extends BaseViewHolder implements NewsItemViewModel.NewsItemViewModelListener {

        private final ItemNewsViewBinding mBinding;

        private NewsItemViewModel mNewsItemViewModel;

        public OpenSourceViewHolder(ItemNewsViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final Articles mNewsItemViewModel = mNewsResponseList.get(position);
            this.mNewsItemViewModel = new NewsItemViewModel(mNewsItemViewModel,this);
            mBinding.setViewModel(this.mNewsItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }


        @Override
        public void onItemClick() {
            if (mNewsResponseList.get(0).getUrl()!= null) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(mNewsResponseList.get(0).getUrl()));
                    itemView.getContext().startActivity(intent);
                } catch (Exception e) {
                    AppLogger.d("url error");
                }
            }
        }
    }
}