package com.xiaoming.basic.life;

import org.springframework.beans.factory.DisposableBean;

public class Production implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy");
    }

    public void myDestroy() throws Exception {
        System.out.println("myDestroy");
    }
}
