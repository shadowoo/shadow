package com.guava.cache.proxy;


/**
 * Created by heshuanglin on 2018/4/24.
 */
public class Owner implements Sales {
    @Override
    public void sell() {
        System.out.println("sell");
    }
}
