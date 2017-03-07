package com.android.jason.baiduweather.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.jason.baiduweather.R;
import com.android.jason.baiduweather.model.bean.Index;
import com.android.jason.baiduweather.databinding.ItemIndexBinding;

import java.util.List;

/**
 * Created by wangshizhan on 16/10/25.
 */

public class IndexAdapter extends BaseBindingAdapter<Index, ItemIndexBinding> {


    public IndexAdapter(Context context, List<Index> indices) {
        super(context, indices);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        bindChildHolder((BaseBindingHolder)holder, position);
    }

    @Override
    protected void bindChildHolder(BaseBindingHolder holder, int position) {
        Index index = list.get(position);
        holder.binding.setVariable(com.android.jason.baiduweather.BR.index, index);
        holder.binding.executePendingBindings();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_index;
    }

}
