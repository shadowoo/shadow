package com.guava.cache.TheadPool;

/**
 * Created by heshuanglin on 2017/12/15.
 */
public class Consumer implements  Runnable {

    String name;
    Storage s;

    Consumer(Storage s,String name){
        this.s = s;
        this.name = name;
    }

    @Override
    public void run() {
        Product product =  s.poll();
    }
}
