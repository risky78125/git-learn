package com.lanou3g.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanou3g.demo.pojo.Person;
import com.lanou3g.demo.pojo.User;

import java.io.IOException;
import java.util.Date;

/**
 * 创建人: 武奇
 * 创建事件: 2019/7/31
 */
public class JacksonMain {

    public static void main(String[] args) {
        // 什么叫解析
        // 从一个有特定格式的字符串中提取数据
        // 常用的格式: xml json
        // json格式的数据有两种类型:
        // {} 括起来的叫做对象 Object
        // [] 括起来的叫做数组 Array
        // 序列化: java对象 -> json数据
        // 反序列化: json数据 -> java对象
        // 完成序列化和反序列化的过程使用框架来完成
        // jackson  gson  fastjson

        String json = "{\"username\": \"zhangsan\"}";
        // 1. 创建一个与json数据结构一样的一个类
        // 2. 使用框架来进行解析
        ObjectMapper mapper = new ObjectMapper();

        // null值不进行序列化


        try {
            User user = mapper.readValue(json, User.class);
            System.out.println(user.getUsername());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Person p = new Person(1L, "wangwu", 28);
        p.setBirthday(new Date());
        try {
            String s = mapper.writeValueAsString(p);
            System.out.println(s);

            mapper.writeValue(System.out, p);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
