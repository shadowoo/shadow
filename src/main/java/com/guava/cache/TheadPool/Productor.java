package com.guava.cache.TheadPool;

/**
 * Created by heshuanglin on 2017/12/15.
 */
public class Productor implements Runnable {


    String name;
    Storage s;

    Productor(Storage s,String name){
        this.s = s;
        this.name = name;
    }

    @Override
    public void run() {

        s.push(new Product(1));

    }
}
