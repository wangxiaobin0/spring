package com.spring.cglib;

import com.spring.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        ProductImpl producer = new ProductImpl();

        /**
         * 基于子类的动态代理
         * 前提:被代理类不能是最终类(被final修饰)
         * 提供:cglib
         * 实现:Enhancer的create方法.
         *
         */

        ProductImpl cglibProducer = (ProductImpl)Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *
             * @param o 被代理对象引用
             * @param method 当前执行的方法
             * @param objects 当前执行方法的参数
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Float money = (Float) objects[0];
                if ("sale".equals(method.getName())) {
                    return method.invoke(producer, money * 0.8f);
                }
                return method.invoke(producer, objects);
            }
        });

        cglibProducer.sale(20000f);
        cglibProducer.afterSale(20000f);

    }
}
