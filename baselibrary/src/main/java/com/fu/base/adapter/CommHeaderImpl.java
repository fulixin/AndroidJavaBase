package com.fu.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fu.base.view.SwipeItemLayout;

/**
 * Created by fulixin on 2017/8/17.
 */

public class CommHeaderImpl {
    private View convertView;

    public CommHeaderImpl(Context mContext, View convertView, ViewGroup parent, int layoutId, int layoutRightId) {
        if (layoutRightId == 0) {
            convertView = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
        } else {
            View view1 = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
            View view2 = LayoutInflater.from(mContext).inflate(layoutRightId, parent, false);
            convertView = new SwipeItemLayout(view1, view2, null, null);
        }
        convertView.setTag(this);
        this.convertView = convertView;
    }

    public static CommHeaderImpl get(Context mContext, View convertView, ViewGroup parent, int layoutId, int layoutRightId) {
        if (convertView != null) {
            return (CommHeaderImpl) convertView.getTag();
        }
        return new CommHeaderImpl(mContext, convertView, parent, layoutId, layoutRightId);
    }

    public View getConvertView() {
        return convertView;
    }
}
