package com.xiaoming.basic;

import com.xiaoming.basic.old.BeanFactory;
import com.xiaoming.basic.old.Person;
import com.xiaoming.basic.old.User;
import com.xiaoming.basic.old.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void test() {
         // UserService userService = new UserServiceImpl();
        UserService userService = (UserService)BeanFactory.getBean("userService");

        // 登录
        userService.login("apem", "apem159");

        // 注册
        User newUser = new User("apem", "apem159");
        userService.register(newUser);


    }

    @Test
    public void test2() {
        Person person = (Person) BeanFactory.getBean("person");
        System.out.println("person = " + person);
    }

    @Test
    public void test3() {
        // 获取-非web环境application的工厂类
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 通过工厂实例 + config的键名 => 获取对应的对象
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }

    @Test
    public void test4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        /**
         * 重载方法一,可以省略的类型强转
         */
        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);

        /**
         * 重载方法二: 直接传入 Class, 需保证Spring配置中只能有一个<bean class="Only">的类型
         * 如果出现同一个class-2次声明,编译会报错:
         *   <bean id="person" class="com.xiaoming.basic.old.Person"></bean>
         *   <bean id="person1" class="com.xiaoming.basic.old.Person"></bean>
         */
        Person person1 = ctx.getBean(Person.class);
        System.out.println(person1);

        /**
         * 获取Bean定义的所有id名字数组
         *  getBeanDefinitionNames([id数组])
         */
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        /**
         * 根据类型获取Spring配置文件中对应的id值
         */
        String[] names2 = ctx.getBeanNamesForType(Person.class);
        for (String name : names2) {
            System.out.println(name);
        }

        /**
         * 判断Spring中是否存在指定id值的bean
         * - 既可以用id属性来判断, 也可以使用 name属性来判断
         */
        boolean isExists = ctx.containsBean("p1");
        System.out.println("存在 ? " + isExists);

        /**
         * 判断Spring中是否存在声明指定id值的bean
         * - 只用通过id属性来判断
         */
        boolean isExists2 = ctx.containsBeanDefinition("person");
        System.out.println("存在 ? " + isExists2);

    }

    @Test
    public void test5() {
        /**
         * 定义bean时，只配置 class
         * <bean class="com.xiaoming.basic.old.Person"></bean>
         */
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = ctx.getBean(Person.class);
        System.out.println(person);

        // 判断只配置class的情况下,系统是否会自动分配id值?
        // 不写id值,Spring会自动分配id值: com.xiaoming.basic.old.Person#0
        String[] names = ctx.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name); // com.xiaoming.basic.old.Person#0
        }
    }

    @Test
    public void test6() {
        /**
         * 测试 bean-name属性
         * <bean id="person" name="p1,p2,p3" class="com.xiaoming.basic.old.Person"></bean>
         */
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
//        Person person = (Person) ctx.getBean("p1");
        System.out.println("person = " + person);
    }

    @Test
    public void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println("person = " + person);
    }

    /**
     * 不同类型的成员变量赋值
     */
    @Test
    public void test8() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = ctx.getBean("person2", Person.class);

        // String[] ages 初始化赋值
        for (String age : person.getAges()) {
            System.out.println("age = " + age);
        }
        System.out.println("person = " + person);
        System.out.println("==============================");

        // Set<String> bobbits 初始赋值
        for (String hobbit : person.getHobbits()) {
            System.out.println("爱好：" + hobbit);
        }
        System.out.println("==============================");

        // List<String> addresses 初始化赋值
        for (String address : person.getAddresses()) {
            System.out.println("地址：" + address);
        }
        System.out.println("==============================");

        // Map<String, Integer> scores 初始化赋值
        for (String key : person.getScores().keySet()) {
            System.out.println(key + ": " + person.getScores().get(key));
        }
        System.out.println("==============================");

        // Properties pops 初始化赋值
        for (Object key : person.getPops().keySet()) {
            System.out.println("key = " + key + " ,value = " + person.getPops().get(key));
        }
    }

    /**
     * 测试-用户自定义类型的成员变量的初始化赋值
     */
    @Test
    public void test9() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = ctx.getBean("userService", UserService.class);

        userService.register(new User("猪八戒", "123456"));
        userService.login("猪八戒", "123456");
    }
}
