package com.xiaoming.basic.old;

public interface UserDAO {
    public void save(User user);
    public void querySelectByUsernameAndPassword(String username, String password);
}