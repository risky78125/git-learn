package com.lanou3g.demo;

import com.lanou3g.demo.pojo.Person;
import com.lanou3g.demo.pojo.Product;
import com.lanou3g.demo.pojo.ProductVO;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 创建人: 武奇
 * 创建事件: 2019/7/31
 */
public class Main {
    public static void main(String[] args) {
        /*
        1. 反射
        2. git 命令行
        3. spring-cloud 统一配置 config, 运行监控
        4. 接口文档(测试)工具, swagger2
        5. 数据库相关-索引. 联合主键. 视图-存储过程-执行计划-常用函数.
        6. 微服务中的登录
        7. json解析: jackson  gson  fastjson
        8. 数组排序
        9. java8特性
        10. excel 导入导出
         */

        // 1. 反射
        /*
        1. 有两个类A和B, 他们有一些同样的属性, 要求实现一个功能,
        把A对象的属性值赋值给B对象.
        2. 把一个pojo对象转换为Map
        2.1: 动态的获取到这个对象有多少个属性, 然后进行遍历
        2.2: 可以获取到这个属性的名字
        2.3: 获取到某个对象的某个属性的值
         */
        Object obj = new Person(1L, "zhangsan", 18);
        Map<String, Object> map = map(obj);
        System.out.println(map);

        Person p = map(map, Person.class);

        Product pro = new Product();

        ProductVO pv = new ProductVO();

        pv.setName("手机");
        pv.setPrice(1280.00F);

        copy(pv, pro);

        System.out.println(pro);


    }

    /**
     * 把一个实体类转换为Map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> map(Object obj) {
        Class<?> clazz = obj.getClass();
        // 获取某个对象的所有属性
        Field[] fields = clazz.getDeclaredFields();

        Map<String, Object> map = new HashMap<>();
        try {
            for (Field field : fields) {
                String key = field.getName();
                // 获取obj对象的field属性的值
                // 如果某个属性是私有的, 而且还想访问
                // 那么把这个属性设置为可访问的
                field.setAccessible(true);
                Object value = field.get(obj);
                // 一般情况下, 用完了, 再复原
                field.setAccessible(false);
                map.put(key, value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;


    }

    // 把一个map转换为某个对象
    public static <T> T map(Map<String, Object> map, Class<T> clazz) {
        // 1. 通过class来创建一个对象
        try {
            T obj = clazz.newInstance();
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                String name = entry.getKey(); // 属性名
                Object value = entry.getValue(); // 属性值
                try {
                    Field field = clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    // 为obj对象的field属性赋值为value
                    field.set(obj, value);
                    field.setAccessible(false);
                } catch (NoSuchFieldException ignore) {
                }
            }
            return obj;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把src对象的所有属性的值, 同步到target对象
     * @param src
     * @param target
     */
    public static void copy(Object src, Object target) {
        Class<?> srcClazz = src.getClass();
        Class<?> tarClazz = target.getClass();
        Field[] srcFields = srcClazz.getDeclaredFields();
        for (Field srcField : srcFields) {
            String name = srcField.getName();
            srcField.setAccessible(true);
            try {
                Object value = srcField.get(src);
                srcField.setAccessible(false);
                Field tarField = tarClazz.getDeclaredField(name);
                tarField.setAccessible(true);
                tarField.set(target, value);
                tarField.setAccessible(false);
            } catch (Exception ignore) {
            }
        }
    }
    // 根据一个对象, 生成一个这个类

    public static void generate(Object obj) {
        System.out.println("生成代码");
        System.out.println("修复bug");
        System.out.println("第一个人推送的代码");
        System.out.println("++++++++++");
        System.out.println("++++++++++");
        System.out.println("++++++++++");
        System.out.println("++++++++++");
        System.out.println("-------------");
        System.out.println("-------------");
        System.out.println("-------------");
        System.out.println("-------------");

        /*
        git init 将当前工作目录初始化为git仓库
        git status 查看git状态
        git add 某个文件 将某个文件添加到暂存区
        git add . 将所有文件添加到暂存区
        git commit -m 消息  将暂存区的记录进行提交
        git remote 查看当前git仓库关联了哪些远程仓库, 显示远程仓库的名字
        git remote add [origin] [url]为当前仓库绑定一个远程仓库
            origin 表示远程仓库的名字
            url 表示远程仓库的地址
        git remote remove [origin] 解除与某个远程仓库的关联
        git push -u [origin] [master] 推送当前的分支, 并与远程分支绑定
            origin 推送到某个远程仓库
            master 远程仓库的某个分支
        git push 将当前分支推送到之前绑定的远程分支上
        git push origin master 将本地分支推送到远程某个分支, 不绑定
        git pull origin master 将远程仓库的某个分支拉取到当前分支上
        git pull 根据之前绑定的形式自动拉取
        git log 查看提交记录(内容比较详细)
        git reflog 查看提交记录(内容简洁)
        git clone [url] 将某个远程仓库克隆到本地(会包含已经有的提交记录)

        git checkout -b 分支名 创建新分支并切换
        git checkout 分支名 切换分支
        git branch 查看所有分支
        git merge 分支名 合并分支, 把某个分支合并到当前分支


         */


    }

}
