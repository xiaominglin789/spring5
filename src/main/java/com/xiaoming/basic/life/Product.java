package com.xiaoming.basic.life;

import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product() {
        // <bean id="product" scope="singleton" class="com.xiaoming.basic.life.Product" />
        System.out.println("Spring工厂 create Product");
    }

    // 自定义初始化方法 -> 再配置文件配置调用
    public void init() {
        name = "自定义方法 设置的 name值";
        System.out.println("自定义初始化方法 -> 在配置文件中,配置init-method的方式让Spring调用");
        System.out.println("name = " + name);
    }

    /**
     * Spring提供的初始化方法回调
     *  - 完成初始化逻辑，交给Spring调用
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("完成初始化逻辑，交给Spring调用");
    }
}
