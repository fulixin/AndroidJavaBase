package com.fu.retrofit.github.response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by fulixin on 2017/9/7.
 */

public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private TypeAdapter<T> adapter;
    private TypeToken<T> type;

    public MyGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    public MyGsonResponseBodyConverter(Gson gson, TypeToken<T> type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        if (adapter != null) {
            JsonReader jsonReader = gson.newJsonReader(value.charStream());
            try {
                return adapter.read(jsonReader);
            } finally {
                value.close();
            }
        } else {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(value.string()).getAsJsonObject();
            return gson.fromJson(jsonObject, type.getType());
        }
    }
}
