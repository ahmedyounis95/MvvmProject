package hcww.mvvm.ayounis.com.mvvmproject.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Ahmed Younis on 1/6/2019.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder{
    public BaseViewHolder(View itemView){super(itemView);}

    public abstract void onBind(int position);
}
