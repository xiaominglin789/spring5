package com.xiaoming.basic.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before2 implements MethodBeforeAdvice {
    /**
     * 作用: 把运行在原始方法执行之前的额外功能,书写在`before`方法中
     * @param method 额外功能所增加给的那个原始方法
     *               register()
     *               或 login()
     *               或 showOrder()
     * @param objects 额外功能所增加的那个原始方法的参数列表
     *                register user
     *                或 login username、password
     * @param o 额外功能所增加的那个原始对象
     *          UserServiceImpl
     *          OrderServiceImpl
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("----------new MeothdBeforeAdivce log ---------");
    }
}
