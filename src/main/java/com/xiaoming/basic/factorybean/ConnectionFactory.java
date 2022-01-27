package com.xiaoming.basic.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;

/** 遗留的系统类 - 已提供数据库连接类 - 不能修改 */
public class ConnectionFactory {
    public Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cloud_user?useSSL=false",
                "apem789",
                "apem@159.com");
        return conn;
    }
}
