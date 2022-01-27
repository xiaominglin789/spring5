package com.xiaoming.basic;

import com.xiaoming.basic.base.Liker;
import com.xiaoming.basic.factorybean.ConnectionFactoryBean;
import com.xiaoming.basic.scope.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class TestSpring2 {

    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Liker liker = ctx.getBean("liker", Liker.class);

        System.out.println("liker = " + liker);
    }

    @Test
    public void test02() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 取 Connection
        Connection conn = (Connection) ctx.getBean("conn");
        // conn = com.mysql.cj.jdbc.ConnectionImpl@795509d9
        System.out.println("conn = " + conn);

        // 取 ConnectionFactoryBean
        ConnectionFactoryBean conn2 = (ConnectionFactoryBean) ctx.getBean("&conn");
        // conn2 = com.xiaoming.basic.factorybean.ConnectionFactoryBean@206a70ef
        System.out.println("conn2 = " + conn2);

        // isSigleton() return true 返回同一个对象
        // 取 ConnectionFactoryBean
        ConnectionFactoryBean conn3 = (ConnectionFactoryBean) ctx.getBean("&conn");
        // conn3 = com.xiaoming.basic.factorybean.ConnectionFactoryBean@206a70ef
        System.out.println("conn3 = " + conn3);
    }

    /**
     * 测试 实例工厂创建复杂对象
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn2 = (Connection) ctx.getBean("conn2");
        System.out.println("\nconn2 = " + conn2);
    }

    /**
     * 测试 静态工厂创建复杂对象
     */
    @Test
    public void test4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn3 = (Connection) ctx.getBean("conn3");
        System.out.println("\nconn3 = " + conn3);
    }

    /**
     * 控制 简单对象 创建的次数
     * bean scope属性
     *  默认值: "singleton"
     *  - scope="singleton" 只会创建一次对象
     *  - scope="property" 每一次都创建新对象
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Account a1 = (Account) ctx.getBean("account");
        Account a2 = (Account) ctx.getBean("account");

        /**
         * <bean id="account" class="com.xiaoming.basic.scope.Account"></bean>
         *  - a1 = com.xiaoming.basic.scope.Account@3b69e7d1
         *  - a2 = com.xiaoming.basic.scope.Account@3b69e7d1
         *  默认 scope="singleton"
         */
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
    }
}
