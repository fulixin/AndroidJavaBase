package com.fu.base.tools.data.impl;

import com.fu.base.tools.data.IDataInface;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by fulixin on 2017/7/26.
 */

public class DataInfaceImpl implements IDataInface {
    @Override
    public <T> String entityToJsonStr(T entity) {
        Gson gson = new Gson();
        return gson.toJson(entity);
    }

    @Override
    public <T> JsonObject entityToJson(T entity) {
        JsonParser jsonParser = new JsonParser();
        return jsonParser.parse(entityToJsonStr(entity)).getAsJsonObject();
    }

    @Override
    public <T> T jsonToEntity(JsonObject jsonObject, TypeToken type) {
        Gson gson = new Gson();
        return gson.<T>fromJson(jsonObject, type.getType());
    }

    @Override
    public <T> T jsonStrToEntity(String jsonObject, TypeToken type) {
        Gson gson = new Gson();
        return gson.<T>fromJson(jsonObject, type.getType());
    }

    @Override
    public <T> Map<String, T> jsonToMap(JsonObject jsonObject, TypeToken type) {
        Gson gson = new Gson();
        return gson.<Map<String, T>>fromJson(jsonObject, type.getType());
    }

    @Override
    public <T> Map<String, T> jsonStrToMap(String jsonObject, TypeToken type) {
        Gson gson = new Gson();
        return gson.<Map<String, T>>fromJson(jsonObject, type.getType());
    }

    @Override
    public <T> T jsonToString(JsonObject jsonObject, TypeToken type) {
        Gson gson = new Gson();
        return gson.<T>fromJson(jsonObject, type.getType());
    }

    @Override
    public <T> JsonObject mapToJson(Map<String, T> map) {
        JsonParser jsonParser = new JsonParser();
        return jsonParser.parse(mapToJsonStr(map)).getAsJsonObject();
    }

    @Override
    public <T> String mapToJsonStr(Map<String, T> map) {
        Gson gson = new Gson();
        return gson.toJson(map);
    }

    @Override
    public <T> String listToJsonArrayStr(ArrayList<T> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @Override
    public <T> JsonArray listToJsonArray(ArrayList<T> list) {
        JsonParser jsonParser = new JsonParser();
        return jsonParser.parse(listToJsonArrayStr(list)).getAsJsonArray();
    }

    @Override
    public <T> T jsonArrayToString(JsonArray jsonArray, TypeToken type) {
        Gson gson = new Gson();
        return gson.<T>fromJson(jsonArray, type.getType());
    }

    @Override
    public <T> ArrayList<T> jsonArrayToList(JsonArray jsonArray, TypeToken type) {
        Gson gson = new Gson();
        return gson.<ArrayList<T>>fromJson(jsonArray, type.getType());
    }
}
