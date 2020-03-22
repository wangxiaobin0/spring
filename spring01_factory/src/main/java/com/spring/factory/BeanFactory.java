package com.spring.factory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Properties properties;
    private static Map<String, Object> beanMap;

    static {
        try {
            properties = new Properties();
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"));

            Enumeration beanNames = properties.keys();
            beanMap = new HashMap<String, Object>();
            while (beanNames.hasMoreElements()) {
                String beanName = (String) beanNames.nextElement();
                beanMap.put(beanName, Class.forName(properties.getProperty(beanName)).newInstance());
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化失败");
        }
    }

    public static Object getBean(String beanName) {
        return beanMap.get(beanName);
    }
}
