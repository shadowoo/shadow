package com.guava.cache.current;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by heshuanglin on 2018/4/16.
 */
public class Counter {

    private AtomicInteger atomic = new AtomicInteger(0);

    private  int i = 0;

    public static void main(String args[]){

        final Counter cas = new Counter();

        List<Thread> ts = new ArrayList<>(600);

        long start = System.currentTimeMillis();

        for(int j = 0;j<100;j++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<10000;i++){
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(thread);
        }

        for (Thread t: ts) {
            t.start();
        }
        for (Thread t: ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(cas.i);
        System.out.println(cas.atomic.get());
        System.out.println(System.currentTimeMillis()-start);



    }

    private void safeCount() {
        for(;;){
            int i = atomic.get();
            boolean fun = atomic.compareAndSet(i,++i);
            if (fun){
                break;
            }
        }
    }

    private void count() {
        i++;
    }
}
