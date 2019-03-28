package hcww.mvvm.ayounis.com.mvvmproject.ui.base;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Ahmed Younis on 1/6/2019.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder{
    public BaseViewHolder(View itemView){super(itemView);}

    public abstract void onBind(int position);
}
