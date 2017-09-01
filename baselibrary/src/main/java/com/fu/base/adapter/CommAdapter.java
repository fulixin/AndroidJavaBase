package com.fu.base.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by fulixin on 2017/8/17.
 */

public abstract class CommAdapter<T> extends BaseAdapter {
    private Context mContext;
    private ArrayList<T> datas;

    public CommAdapter(Context mContext, ArrayList<T> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
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
    public int getViewTypeCount() {
        return ViewTypeCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommHeaderImpl commHeader = CommHeaderImpl.get(mContext, convertView, parent, layoutId(getItem(position)), layoutRightId(getItem(position)));
        initdata(commHeader, getItem(position), position);
        return commHeader.getConvertView();
    }

    public abstract void initdata(CommHeaderImpl commHeader, T item, int position);

    public abstract int layoutId(T item);

    public abstract int layoutRightId(T item);

    public abstract int ViewTypeCount();

    public abstract int viewTypeMap(T item);
}
