package com.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        IProducer producer = new ProductImpl();

        /**
         * ClassLoader: 被代理对象的类加载器.固定写法.
         * Class[]: 被代理对象的接口数组.固定写法.
         * InvocationHandler: 被代理对象的所有方法都会经过此类.
         */
        IProducer proxyProducer = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param o 代理对象的引用.一般不用.
             * @param method 当前执行的方法.
             * @param objects 当前执行方法的参数列表
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                Object obj = null;
                if ("sale".equals(method.getName())) {
                    Float money = (Float)objects[0];
                    obj = method.invoke(producer, money * 0.8f);
                    return obj;
                }

                return method.invoke(producer, objects);
            }
        });


        proxyProducer.sale(10000f);
    }
}
