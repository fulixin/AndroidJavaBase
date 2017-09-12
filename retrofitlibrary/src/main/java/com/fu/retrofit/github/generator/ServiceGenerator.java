package com.fu.retrofit.github.generator;

import android.util.Log;

import com.fu.retrofit.github.converter.MyGsonConverterFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * Created by fulixin on 2017/9/4.
 */

public class ServiceGenerator {
    //    public static final String API_BASE_URL = "http://192.168.12.34:8080/gtt/hecspsys/";
    public static final String API_BASE_URL = "http://192.168.7.232:83/nmip/bjgoodwill/doctorapp/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(MyGsonConverterFactory.create());
        Retrofit retrofit = builder.client(httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request oriRequest = chain.request();
                Response response = chain.proceed(getNewRequest(oriRequest));
                responseModify(response);
                return response;
            }
        }).build()).build();
        return retrofit.create(serviceClass);
    }

    private static void responseModify(Response response) {
        //这里不能直接使用response.body().string()的方式输出日志
        // 因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一
        // 个新的response给应用层处理
        try {
            ResponseBody responseBody = response.peekBody(1024 * 1024);
            Log.d("infe", "响应头：" + response.code());
            Log.d("infe", "请求地址：" + response.request().url());
            Log.d("infe", "返回数据：" + responseBody.string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Request getNewRequest(Request oriRequest) {
        Request newRequest = oriRequest.newBuilder()
                .header("token", "oneself_token")
                .build();
        return newRequest;
    }
}
