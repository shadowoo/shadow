package com.guava.cache.dataStructure;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by heshuanglin on 2017/12/15.
 */
public class ThreadTest {

    static ExecutorService  pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue();



    public static void main(String args[]){

        pool.submit(new ThreadPoolTask());


    }

    static class  ThreadPoolTask implements Runnable{


        @Override
        public void run() {
              String s =  queue.poll();
              System.out.println("消费："+s);

        }
    }


}
