package com.xiaoming.basic.old;

public class UserDAOImpl implements  UserDAO {

    @Override
    public void save(User user) {
        System.out.println("insert into user = " + user);
    }

    @Override
    public void querySelectByUsernameAndPassword(String username, String password) {
        System.out.println("query User username = " + username + ", password = " + password);
    }
}
