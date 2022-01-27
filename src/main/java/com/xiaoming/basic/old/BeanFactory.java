package com.xiaoming.basic.old;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 工厂: 对象生成器
 */
public class BeanFactory {
    private static Properties env = new Properties();
    static {
        // 获得io输入流
        // 读取配置文件内容 xxx.yml / xxx.properties / xxx.xml
        // 文件的内容 k-v 加载到 env 中,即可通过 env.getProperty(key) 获取到对应的value
        try {
            InputStream io = ClassLoader.getSystemResourceAsStream("applicationContext.properties");
            env.load(io);
            io.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据key获取对象
     * @param key 配置文件对应的 key 键名
     * @return
     */
    public static synchronized Object getBean(String key) {
        Object result = null;
        try {
            Class clazz = Class.forName(env.getProperty(key));
            result = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;
    }
}
