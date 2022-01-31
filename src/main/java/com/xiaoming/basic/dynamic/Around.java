package com.xiaoming.basic.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Around implements MethodInterceptor {
    /**
     * 作用: 把额外功能增加给 原始方法执行的 前、后、前后
     * @param methodInvocation 额外功能所增加的那个方法
     *                        methodInvocation.proceed(); -> showOrder() 或 ... 运行
     * @return 原始方法执行后的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 之前的额外功能
        // TODO
        System.out.println("-----------MethodInterceptor before log-----------");

        // 让原始方法运行
        Object result = methodInvocation.proceed();

        // 之后的额外功能
        // TODO
        System.out.println("-----------MethodInterceptor after log-----------");

        return result;
    }
}
