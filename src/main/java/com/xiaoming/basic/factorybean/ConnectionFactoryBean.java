package com.xiaoming.basic.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接对象
 *  - 复杂对象, 通过实现FactoryBean完成 Spring复杂对象创建
 */
public class ConnectionFactoryBean implements FactoryBean<Connection> {
    private String driverClassName;
    private String ulr;
    private String username;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUlr() {
        return ulr;
    }

    public void setUlr(String ulr) {
        this.ulr = ulr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Connection getObject() throws Exception {
        // mysql 8.0+  需使用 com.mysql.cj.jdbc.Driver
        Class.forName(driverClassName);
        Connection conn = DriverManager.getConnection(ulr, username, password);
        return conn;
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
