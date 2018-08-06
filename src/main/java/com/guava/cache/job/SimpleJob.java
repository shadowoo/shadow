package com.guava.cache.job;

import java.lang.reflect.Field;

/**
 * Created by heshuanglin on 2018/4/12.
 */
public class SimpleJob {


    public static void main(String args[]) throws NoSuchFieldException, IllegalAccessException {
        test();
    }





    public static void test() throws NoSuchFieldException, IllegalAccessException {
        String s = "hello";
        rs(s);
        System.out.println(s);
    }

    private static void rs(String s) throws NoSuchFieldException, IllegalAccessException {
        Field field = String.class.getDeclaredField("value");
        System.out.println(field.toString());
        field.setAccessible(true);
        field.set(s,"world".toCharArray());
    }
}
