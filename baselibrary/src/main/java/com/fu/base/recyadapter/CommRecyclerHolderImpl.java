package com.fu.base.recyadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * DESC RecycleView的公用ViewHolder
 * Created by douhaoqiang on 2016/9/7.
 */

public class CommRecyclerHolderImpl extends RecyclerView.ViewHolder {
    private View convertView;

    public CommRecyclerHolderImpl(View convertView) {
        super(convertView);
        convertView.setTag(this);
        this.convertView = convertView;
    }

    public static CommRecyclerHolderImpl get(Context mContext, ViewGroup parent, int layoutId) {
        return new CommRecyclerHolderImpl(LayoutInflater.from(mContext).inflate(layoutId, parent, false));
    }

    public View getConvertView() {
        return convertView;
    }
}
