package com.guava.cache.thread;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * Created by heshuanglin on 2018/4/17.
 */
public class Thread_pool {

    ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();

    public static class Policy implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("拒绝策略");
        }
    }

    public static void main(String args[]){


        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,
                10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1),new Policy());



        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行1");
            }
        });
        System.out.println("线程池任务数："+executor.getTaskCount());
//        executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("执行2");
//            }
//        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行3");
            }
        });
        System.out.println("线程池任务数："+executor.getTaskCount());
        for ( int i = 0;i<100;i++){
            System.out.println("线程池任务数123："+executor.getTaskCount());
            Future future = executor.submit(new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(2000);
                    return "操作成功";
                }
            }));
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }






    }


    public void thred(){
        final HashMap<String,String > hashMap = new HashMap<>(2);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                    hashMap.put(UUID.randomUUID().toString(),"");
                }
            }
        },"ftf");

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
