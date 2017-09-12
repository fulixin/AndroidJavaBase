package com.fu.okhttp.impl;

import com.fu.okhttp.IOkHttpRequest;
import com.fu.okhttp.callback.OKCallBack;
import com.fu.okhttp.util.TTypeUtils;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by fulixin on 2017/9/11.
 */

public class OkHttpRequestImpl implements IOkHttpRequest {
    private static OkHttpRequestImpl okHttpRequest;
    private static String url = "http://192.168.7.232:83/nmip/bjgoodwill/doctorapp/loginApp_doctorapp_login.action";
    private OkHttpClient mHttpClient;
    private Request.Builder builder;
    private OKCallBack okCallBack;

    public static OkHttpRequestImpl initialze() {
        if (okHttpRequest == null)
            okHttpRequest = new OkHttpRequestImpl().creat();
        okHttpRequest.baseUrl(url);
        return okHttpRequest;
    }

    public OkHttpRequestImpl creat() {
        mHttpClient = new OkHttpClient.Builder().build();
        mHttpClient.newBuilder().connectTimeout(10, TimeUnit.SECONDS);
        mHttpClient.newBuilder().readTimeout(10, TimeUnit.SECONDS);
        mHttpClient.newBuilder().writeTimeout(10, TimeUnit.SECONDS);
        builder = new Request.Builder();
        return this;
    }

    @Override
    public IOkHttpRequest addHeader(String name, String value) {
        builder.addHeader(name, value);
        return this;
    }

    @Override
    public IOkHttpRequest baseUrl(String url) {
        builder.url(url);
        return this;
    }

    @Override
    public IOkHttpRequest parmtJson(String jsonObject) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject);
        builder.post(body);
        return this;
    }

    @Override
    public IOkHttpRequest parmtMap(Map<String, Object> map) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
            builder.add(stringObjectEntry.getKey(), (String) stringObjectEntry.getValue());
        }
        this.builder.post(builder.build());
        return this;
    }

    @Override
    public IOkHttpRequest parmtFile(File file) {
        builder.post(RequestBody.create(MediaType.parse("text/x-markdown; charset=utf-8"), file));
        return this;
    }

    @Override
    public IOkHttpRequest setCallback(OKCallBack okCallBack) {
        this.okCallBack = okCallBack;
        return this;
    }

    @Override
    public <T> IOkHttpRequest enqueue() {
        mHttpClient.newCall(builder.build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                okCallBack.onFailure(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String type = TTypeUtils.getTType(okCallBack.getClass());
                    Class<T> clazz = (Class<T>) Class.forName(type);
                    Gson gson = new Gson();
                    okCallBack.onResponse(call, (T) gson.fromJson(response.body().string(), clazz));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        return this;
    }

    @Override
    public <T> IOkHttpRequest enqueue(String url, final OKCallBack okCallBack) {
        builder.url(url);
        mHttpClient.newCall(builder.build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                okCallBack.onFailure(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String type = TTypeUtils.getTType(okCallBack.getClass());
                    Class<T> clazz = (Class<T>) Class.forName(type);
                    Gson gson = new Gson();
                    okCallBack.onResponse(call, (T) gson.fromJson(response.body().string(), clazz));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        return this;
    }
}
