package com.guava.cache.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by heshuanglin on 2018/4/24.
 */
public class ProxyHandler implements InvocationHandler {

    private Object target;


    public ProxyHandler(Object target ){
        this.target = target;
    }





    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(target,args);

        return result;
    }
}
