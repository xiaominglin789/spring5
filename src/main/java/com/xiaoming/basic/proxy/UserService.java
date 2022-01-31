package com.xiaoming.basic.proxy;

public interface UserService {
    public void register(User user);
    public boolean login(String name, String password);
}
