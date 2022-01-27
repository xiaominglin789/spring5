package com.xiaoming.basic.base;

public class Liker {
    private String name;
    private int age;

    public Liker(String name) {
        System.out.println("Liker 参数 name 的构造 被调用");
        this.name = name;
    }

    public Liker(int age) {
        System.out.println("Liker 参数 age 的构造 被调用");
        this.age = age;
    }

    public Liker(String name, int age) {
        System.out.println("Liker 参数 age、name 的构造 被调用");
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Liker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
