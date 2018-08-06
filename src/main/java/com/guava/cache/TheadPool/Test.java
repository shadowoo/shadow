package com.guava.cache.TheadPool;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by heshuanglin on 2017/12/15.
 */
public class Test {
    private static final String USER_ID = "user:%s";

    public static  void  main(String args[]){

//        SimpleDateFormat format = new SimpleDateFormat("YYYYMMddHHmmss");
//
//        System.out.println(format.format(new Date()));
//
//        System.out.println(UUID.randomUUID().toString().replace("-", ""));


//        String key = String.format(USER_ID,"123");
//        System.out.println(key);


//        Semaphore semaphore = new Semaphore(3);
//        System.out.println("初始化："+semaphore.availablePermits());
//        System.out.println("初始化："+semaphore.drainPermits());
//        try {
//            semaphore.acquire();
//            System.out.println("使用中："+semaphore.availablePermits());
//            System.out.println("使用中："+semaphore.drainPermits());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        semaphore.release();
//        System.out.println("使用后："+semaphore.availablePermits());
//        System.out.println("使用后："+semaphore.drainPermits());


//        AtomicInteger a = new AtomicInteger(1);
//        System.out.println(a.get());
//
//        System.out.println(a.incrementAndGet());
//        System.out.println(a.get());
//        System.out.println(a.decrementAndGet());
//        System.out.println(a.get());

//        ConcurrentHashMap<String,AtomicInteger> map = new ConcurrentHashMap<>();
//
//        map.put("123",new AtomicInteger(1));
//        System.out.println(map.get("123"));
////        System.out.println(map.get("12322"));
//        AtomicInteger atomicInteger = map.get("123");
//        atomicInteger.decrementAndGet();
//
//        map.put("123",atomicInteger);
//
//        System.out.println(map.get("123"));
//        map.put("测试",1);
//
//        int nn = map.get("123");
//        System.out.println(nn);
//
//        map.put("测试",1);
//
//        map.put("测试",1);
//
//        System.out.println(map.get("测试"));

//        ScheduledExecutorService service = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

//        Storage storage = Storage.getInstance();
//
//        new Thread(() -> {
//            while (true){
//                Random random = new Random();
//
//                storage.push(new Product(random.nextInt(1000)));
//
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                while (true){
//                    Random random = new Random();
//
//                    storage.push(new Product(random.nextInt(1000)));
//
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();


//        service.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                if(!storage.isEmpty()){
//                    storage.poll();
//                }
//
//            }
//        },0,3, TimeUnit.SECONDS);

    }}
