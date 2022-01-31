package com.xiaoming.basic.proxy;

public class UserServiceImpl implements UserService {

    @Override
    public void register(User user) {
        // 业务运算+DAO
        System.out.println("业务运算+DAO");
    }

    @Override
    public boolean login(String name, String password) {
        // 业务运算+DAO
        System.out.println("业务运算+DAO");
        return true;
    }
}
