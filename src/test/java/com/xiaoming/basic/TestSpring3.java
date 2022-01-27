package com.xiaoming.basic;

import com.xiaoming.basic.life.Product;
import com.xiaoming.basic.life.Production;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring3 {

    @Test
    public void test() {
        //  工厂创建创建同时, scope="singleton"的bean也会被创建出来
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");

        //  scope="singleton" + lazy-init="true" 的bean 在获取时才创建出来
//        Product product1 = (Product) ctx.getBean("product1");
//
//        // scope="property"的bean在 工厂获取bean时才会被创建。
//        Product product2 = (Product) ctx.getBean("product2");

        // 先注入 后init
        Product product3 = (Product) ctx.getBean("product3");
        System.out.println("product3.getName() = " + product3.getName());
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Production production = (Production) ctx.getBean("production");
        ctx.close();
    }
}
