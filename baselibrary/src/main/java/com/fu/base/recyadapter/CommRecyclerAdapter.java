package com.fu.base.recyadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by fulixin on 2017/8/17.
 */

public abstract class CommRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ArrayList<T> datas;

    public CommRecyclerAdapter(Context mContext, ArrayList<T> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    public T getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return viewTypeMap(getItem(position));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommRecyclerHolderImpl.get(mContext, parent, layoutId(viewType));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        initdata((CommRecyclerHolderImpl) holder, getItem(position), position);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public abstract void initdata(CommRecyclerHolderImpl commHeader, T item, int position);

    public abstract int layoutId(int item);
    public abstract int viewTypeMap(T item);
}
