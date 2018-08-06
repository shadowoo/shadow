package com.guava.cache.TheadPool;

/**
 * Created by heshuanglin on 2017/12/15.
 */
public class Product {

    private int id;

    Product(int id){
        this.id = id;
    }

    public String toString(){
        return "产品 ："+this.id;
    }
}
