package com.xiaoming.basic.old;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
    private Integer id;
    private String name;
    private String[] ages;
    private Set<String> hobbits;
    private List<String> addresses;
    private Map<String, Integer> scores;
    // Properties 是特殊的Map k:String v:String
    private Properties pops;
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Properties getPops() {
        return pops;
    }

    public void setPops(Properties pops) {
        this.pops = pops;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<String, Integer> scores) {
        this.scores = scores;
    }



    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getHobbits() {
        return hobbits;
    }

    public void setHobbits(Set<String> hobbits) {
        this.hobbits = hobbits;
    }

    public String[] getAges() {
        return ages;
    }

    public void setAges(String[] ages) {
        this.ages = ages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("setId 被调用、id = " + id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName 被调用、name = " + name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Person() {
        System.out.println("person 无参构造方法被调用、");
    }
}
