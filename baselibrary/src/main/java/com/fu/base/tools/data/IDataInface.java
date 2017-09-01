package com.fu.base.tools.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by fulixin on 2017/7/26.
 */

public interface IDataInface {
    /**
     * 实体类转json字符串
     */
    <T> String entityToJsonStr(T entity);

    /**
     * 实体类转json
     */
    <T> JsonObject entityToJson(T entity);

    /**
     * json转实体类
     */
    <T> T jsonToEntity(JsonObject jsonObject, TypeToken type);

    /**
     * json字符串转实体类
     */
    <T> T jsonStrToEntity(String jsonObject, TypeToken type);

    /**
     * json转map
     */
    <T> Map<String, T> jsonToMap(JsonObject jsonObject, TypeToken type);

    /**
     * json字符串转map
     */
    <T> Map<String, T> jsonStrToMap(String jsonObject, TypeToken type);

    /**
     * json转String
     */
    <T> T jsonToString(JsonObject jsonObject, TypeToken type);

    /**
     * map转json
     */
    <T> JsonObject mapToJson(Map<String, T> map);

    /**
     * map转json字符串
     */
    <T> String mapToJsonStr(Map<String, T> map);

    /**
     * list转jsonarray字符串
     */
    <T> String listToJsonArrayStr(ArrayList<T> list);

    /**
     * list转jsonarray
     */
    <T> JsonArray listToJsonArray(ArrayList<T> list);

    /**
     * jsonarray转String
     */
    <T> T jsonArrayToString(JsonArray jsonArray, TypeToken type);

    /**
     * jsonarray转list
     */
    <T> ArrayList<T> jsonArrayToList(JsonArray jsonArray, TypeToken type);
}
