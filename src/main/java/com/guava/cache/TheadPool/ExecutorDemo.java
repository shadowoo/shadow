package com.guava.cache.TheadPool;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by heshuanglin on 2018/5/22.
 */
public class ExecutorDemo {


    private static AtomicInteger atomicInteger = new AtomicInteger(0);


    public static void main(String args[]){

        final ExecutorService executor = Executors.newFixedThreadPool(5);

        Future future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return atomicInteger.incrementAndGet();
            }
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
