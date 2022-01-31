package com.xiaoming.basic.proxy;

public class UserServiceProxy implements UserService {
    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void register(User user) {
        // 额外功能
        System.out.println("--log--");
        // 调用原始类的同名原始方法
        userService.register(user);
    }

    @Override
    public boolean login(String name, String password) {
        // 额外功能
        System.out.println("--log--");
        // 调用原始类的同名原始方法
        return userService.login(name, password);
    }
}
