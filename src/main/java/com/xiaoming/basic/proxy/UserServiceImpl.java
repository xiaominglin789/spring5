package com.xiaoming.basic.proxy;

import com.xiaoming.basic.annotation.Log;

public class UserServiceImpl implements UserService {

    @Log
    @Override
    public void register(User user) {
        // 业务运算+DAO
        System.out.println("register 业务运算+DAO");
    }

    @Override
    public boolean login(String name, String password) {
        // 业务运算+DAO
        System.out.println("login 业务运算+DAO");
        return true;
    }
}
