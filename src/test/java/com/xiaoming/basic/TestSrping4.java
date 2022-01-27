package com.xiaoming.basic;

import com.xiaoming.basic.beanpost.Category;
import com.xiaoming.basic.beanpost.MyBeanPostProcessor;
import com.xiaoming.basic.converter.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class TestSrping4 {
    /**
     * 用于测试: Spring配置文件转移到db小配置
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);
    }

    /**
     * 用于测试: 自定义类型转换器
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext3.xml");
        com.xiaoming.basic.converter.Person person = (com.xiaoming.basic.converter.Person) ctx.getBean("person");

        System.out.println("person = " + person);
        System.out.println("birthday = " + person.getBirthday());
    }

    /**
     * 用于测试: 后只处理Bean-BeanPostProcessor
     */
    @Test
    public  void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext4.xml");
        Category category = (Category) ctx.getBean("category");

        System.out.println("mbp = " + category.getName());
    }
}
