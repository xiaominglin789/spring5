package com.xiaoming.basic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 *  - 先添加元注解
 *  - 1.@Target(ElementType.METHOD) 作用在方法上
 *  - 2.@Retention(RetentionPolicy.RUNTIME) 固定:运行时起作用
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
}
