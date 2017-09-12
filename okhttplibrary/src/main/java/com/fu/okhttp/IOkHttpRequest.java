package com.fu.okhttp;

import com.fu.okhttp.callback.OKCallBack;

import java.io.File;
import java.util.Map;

/**
 * Created by fulixin on 2017/9/11.
 */

public interface IOkHttpRequest {
    /**
     * 基础创建
     *
     * @return
     */
    IOkHttpRequest creat();

    /**
     * 设置请求头
     *
     * @param name
     * @param value
     * @return
     */
    IOkHttpRequest addHeader(String name, String value);

    /**
     * 设置url
     *
     * @return
     */
    IOkHttpRequest baseUrl(String url);

    /**
     * 添加json数据
     *
     * @return
     */
    IOkHttpRequest parmtJson(String jsonObject);

    /**
     * 添加map数据
     *
     * @return
     */
    IOkHttpRequest parmtMap(Map<String, Object> map);

    /**
     * 发送文件数据
     *
     * @return
     */
    IOkHttpRequest parmtFile(File file);

    /**
     * 设置回调
     *
     * @return
     */
    IOkHttpRequest setCallback(OKCallBack okCallBack);

    /**
     * 执行请求
     *
     * @return
     */
    <T> IOkHttpRequest enqueue();

    /**
     * 执行请求
     *
     * @return
     */
    <T> IOkHttpRequest enqueue(String url, OKCallBack okCallBack);
}
