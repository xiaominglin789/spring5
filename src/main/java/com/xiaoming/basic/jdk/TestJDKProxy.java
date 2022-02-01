package com.xiaoming.basic.jdk;


import com.xiaoming.basic.proxy.User;
import com.xiaoming.basic.proxy.UserService;
import com.xiaoming.basic.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {
    public static void main(String[] args) {
        // 1. 创建原始对象
        UserService userService = new UserServiceImpl();

        // 额外功能接口实现
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 之前的加入-额外功能
                // TODO
                System.out.println("----------log---------");

                // 运行原始方法
                Object obj = method.invoke(userService, args);

                // 之后的加入-额外功能
                // TODO

                return obj;
            }
        };

        // 2.jdk创建动态代理创建代理类。
        /**
         * Proxy.newProxyInstance() 就是动态字节码技术 -> 创建字节码
         *  - 注意: jdk1.8之前 创建原始对象
         *         final UserService userService = new UserServiceImpl();
         * classLoader 借用一个类加载器: 1.通过类加载器把对应类的字节码文件加载到虚拟机JVM
         *                            2.通过`类加载器`创建类的`Class对象`,进而创建这个类的`对象`
         *                              User -创建-> user对象
         *                              User类Class对象 -> new User -> user对象
         *                            -> 借用一个类加载器, 完成代理类Class对象的创建
         *                            -> 借用一个类加载器：可以是TestJDKProxy、UserService、UserServiceImpl
         * interfaces 代理类和原始类实现相同的接口
         * ivocationHander 额外功能接口实现
         */
        UserService userServiceProx = (UserService) Proxy.newProxyInstance(
                UserService.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                handler
        );

        userServiceProx.login("123", "123"); // 已经加入额外功能
        userServiceProx.register(new User()); // 已经加入额外功能
    }
}
