package com.fu.base;

/**
 * Created by fulixin on 2017/7/26.
 */

public class Book {
    public Book() {
    }

    public Book(String name, String nice, String age) {
        this.age = age;
        this.name = name;
        this.nice = nice;
    }

    private String name;
    private String nice;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNice() {
        return nice;
    }

    public void setNice(String nice) {
        this.nice = nice;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名：" + name + ",昵称：" + nice + ",年龄：" + age;
    }
}
