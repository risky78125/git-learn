package com.lanou3g.demo.pojo;

import java.util.Date;

/**
 * 创建人: 武奇
 * 创建事件: 2019/7/31
 */
public class Product {

    private Long id;
    private String name;
    private Float price;
    private Date createTime;
    private Date updateTime;
    private Boolean deleteFlag;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
