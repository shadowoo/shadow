package com.guava.cache.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by heshuanglin on 2018/4/24.
 */
public class Test {

    public static void main(String arg[]){

        Sales owner = new Owner();

        ProxyHandler handler = new ProxyHandler(owner);

        Sales proxy = (Sales) Proxy.newProxyInstance(owner.getClass().getClassLoader(),owner.getClass().getInterfaces(),handler);

        proxy.sell();

    }
}
