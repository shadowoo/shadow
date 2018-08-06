package com.guava.cache.TheadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshuanglin on 2017/12/15.
 */
public class Storage {

    private LinkedBlockingQueue<Product> queue = new LinkedBlockingQueue<>();

    private ScheduledExecutorService service = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());


    private static volatile Storage storage;


    private Storage(){
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("检测队列");
                if(!isEmpty()) {
                    poll();
                }
            }
        },0,3, TimeUnit.SECONDS);

    }


    public static Storage getInstance(){
        if (storage == null){
            synchronized (Storage.class){
                if (storage == null){
                    storage = new Storage();
                }
            }
        }
        return  storage;
    }


    public boolean push(Product product){
            System.out.println("生产产品："+product.toString());
            return  queue.offer(product);
    }


    public Product poll(){
            Product product = queue.poll();
            System.out.println("消耗产品："+product.toString());
            return  product;
    }

    public boolean isEmpty(){
          return   queue.isEmpty();

    }
}
