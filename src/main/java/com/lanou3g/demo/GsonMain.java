package com.lanou3g.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lanou3g.demo.pojo.Person;

import java.util.Date;

/**
 * 创建人: 武奇
 * 创建事件: 2019/7/31
 */
public class GsonMain {
    public static void main(String[] args) {

        Person p = new Person(1L, "wangwu", 28);
        p.setBirthday(new Date());


        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = builder.create();

        String json = gson.toJson(p);

        System.out.println(json);


    }
}
