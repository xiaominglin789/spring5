package com.xiaoming.basic.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before implements MethodBeforeAdvice {

    /**
     * 作用: 把运行在原始方法执行之前的额外功能,书写在`before`方法中
     * @param method
     * @param objects
     * @param o
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("--------methodBeforeAdvice log --------");
    }
}
