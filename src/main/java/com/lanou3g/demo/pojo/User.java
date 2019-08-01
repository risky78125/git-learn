package com.lanou3g.demo.pojo;

/**
 * 创建人: 武奇
 * 创建事件: 2019/7/31
 */
public class User {

    /*

    对http的理解:
    1. 超文本传输协议, 应用层(OSI参考模型, TCP/IP模型)协议,
        基于传输层的TCP(三次握手, 为什么)协议
    2. 是一个请求响应模型, 只有客户端发起请求了, 服务端才会给响应.
        只能客户端主动发起.
       (如果需要服务端主动向客户端发起消息咋办, WebSocket,
        客户端与服务端建立一个一直存在的一个连接)
    3. 请求:
        请求行: 请求方法 请求地址 http协议版本
        请求头: 多个键值对, 每个键值对都是一个头, 一行一个请求头
        请求体: 与请求头之间有一个空行, 真正需要往后台发送的数据
    4. 请求方法:
        GET: 没有请求体, 所以数据只能放到url的后面, 传递简单的键值对
        POST: 有请求体, 所以数据可以放到请求体里, 可以传递任意数据, JSON/XML/复杂的文件等
        PUT:
        DELETE:
        OPTIONS: 跨域的时候, 前端发送了一个非简单请求时, 会提前发送一个预检请求,
            这个预检请求的请求方法就是OPTIONS.
        HEAD: 用来提前检查服务器资源是否存在的
            发起head请求的时候, 服务器只会把响应头返回回来, 没有响应体
        传统开发下, 使用最多的就是GET和POST,
        GET描述的是想从服务器获取数据,
        POST描述的是想向服务器发送数据.
        在传统的http协议下, GET请求是没有请求体的.
        特殊情况: 在elasticsearch中, 有一些GET请求是需要有请求体的

        PUT和DELETE方法什么时候用:
        前后端分离, 然后接口使用RESTFull风格设计的
        针对一个实体, 增删改查的接口名字一样(/product), 然后使用
        不同的请求方法来标识不同的操作.
        GET: 查询
        POST: 修改
        DELETE: 删除
        PUT: 新增

     5. 请求头:

        Accept: 用来描述客户端想接收到的数据类型
        Content-Type: 用来描述请求体中的数据类型
            application/x-www-form-urlencoded: 键值对
            application/json : json
            multipart/form-data : 发送文件
        Host: 主机地址
        User-Agent: 描述的是客户端的类型(是什么浏览器)
        Referer: 描述的是本次请求是从哪个页面发起的
        Cookie: (Cookie - Session)
        自定义一些请求头

     6. 响应
        响应行: http协议版本 响应码 响应码描述
        响应头: 同请求头
        响应体: 同请求体

     7. 响应码:
        2xx: 成功
        3xx: 对http协议的一些控制
        4xx: 客户端问题
        5xx: 服务器问题

        200:
        302: 重定向
        304: 资源在浏览器里被缓存了
        400: 客户端发送的数据与服务端想接收的数据匹配不上
        404: 页面找不到
        415: 请求方法后台不支持
        500: 后台抛异常了

     */

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
