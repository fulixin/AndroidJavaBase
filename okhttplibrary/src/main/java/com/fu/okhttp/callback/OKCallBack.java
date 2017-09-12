package com.fu.okhttp.callback;

import okhttp3.Call;

/**
 * Created by fulixin on 2017/9/11.
 */

public abstract class  OKCallBack<T> {
    public  abstract void onFailure(Call callback, Exception e);

    public abstract void onResponse(Call callback, T t);
}
