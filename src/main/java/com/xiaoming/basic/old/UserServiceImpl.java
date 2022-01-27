package com.xiaoming.basic.old;

public class UserServiceImpl implements UserService {
    //    private UserDAO userDAO = (UserDAO) BeanFactory.getBean("userDAO");
    private UserDAO userDAO;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(User user) {
        userDAO.save(user);
    }

    @Override
    public void login(String username, String password) {
        userDAO.querySelectByUsernameAndPassword(username, password);
    }
}
