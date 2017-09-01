package com.fu.base;

import com.fu.base.tools.httprequest.IHttprequestInface;
import com.fu.base.tools.httprequest.impl.HttpRetrofitInfaceImpl;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
//        Book book = new Book("小李子", "小肥猪", "21");
//        System.out.println("实体：" + book.toString());
//        IDataInface iDataInface = new DataInfaceImpl();
//        JsonObject jsonObject = iDataInface.entityToJson(book);
//        System.out.println("实体转json：" + jsonObject.toString());
//        Book book1 = iDataInface.jsonToEntity(jsonObject, new TypeToken<Book>() {
//        });
//        System.out.println("json转实体：" + book1.toString());
//        Map<String, Book> map = new HashMap<>();
//        map.put("book", book);
//        System.out.println("json封存map：" + map.toString());
//        JsonObject jsonObject1 = iDataInface.mapToJson(map);
//        System.out.println("map转json：" + jsonObject1.toString());
//        Map<String, Book> map1 = iDataInface.jsonToMap(jsonObject1, new TypeToken<Map<String, Book>>() {
//        });
//        System.out.println("json转map：" + map1.toString());
//        ArrayList<Book> lists=new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Book book0 = new Book("小李子"+i, "小肥猪"+i, "2"+i);
//            lists.add(book0);
//        }
//        System.out.println("实体封存数组：" + lists.toString());
//        JsonArray jsonArray=iDataInface.listToJsonArray(lists);
//        System.out.println("数组转json数组：" + jsonArray.toString());
//        ArrayList<Book> lists1=iDataInface.jsonArrayToList(jsonArray,new TypeToken<ArrayList<Book>>(){});
//        System.out.println("json数组转list：" + lists1.toString());


//        IHttprequestInface.IRetrofitInface iRetrofitInface = new HttpRetrofitInfaceImpl().<IHttprequestInface.IRetrofitInface>initializeRetrofit(IHttprequestInface.IRetrofitInface.class);
//        iRetrofitInface.getString("17733333333", "a111111", "docPhone").enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                System.out.print("onResponse");
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                System.out.print("onFailure");
//
//            }
//        });

        new HttpRetrofitInfaceImpl().request();
    }
}