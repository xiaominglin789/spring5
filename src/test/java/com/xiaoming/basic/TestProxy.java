package com.xiaoming.basic;

import com.xiaoming.basic.proxy.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProxy {
    /**
     * 用于测试: 静态代理的代码
     */
    @Test
    public void test1() {
        UserService userService = new UserServiceProxy();
        userService.register(new User());
        userService.login("admin", "123456");
        System.out.println("------------------------");

        OrderService orderService = new OrderServiceProxy();
        orderService.showOrder();
    }

    /**
     * 用于测试：Spring的动态代理
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContextProxy.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        userService.register(new User());
        /**
         * --------methodBeforeAdvice log --------
         * 业务运算+DAO
         */

        userService.login("admin", "12345");
        /**
         * --------methodBeforeAdvice log --------
         * 业务运算+DAO
         */
    }

    /**
     * 用于测试: OrderService的动态代理
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContextProxy.xml");
        OrderService orderService = (OrderService) ctx.getBean("orderService");

        orderService.showOrder();
        /**
         * --------methodBeforeAdvice log --------
         * order的核心功能
         */
    }

    /**
     * 用于测试: 动态代理 MethodInterceptor
     */
    @Test
    public void test4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContextProxy.xml");
        OrderService orderService = (OrderService) ctx.getBean("orderService");

        orderService.showOrder();
    }
}
