package com.guava.cache.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by heshuanglin on 2017/12/11.
 */
public class Cglib  implements MethodInterceptor{

    private static final Logger logger = LoggerFactory.getLogger(Cglib.class);


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("cglib 调用 ："+method.getName());

        System.out.println("调用结果 ："+methodProxy.invokeSuper(o,objects));
        return null;

    }
}
