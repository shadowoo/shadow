package com.guava.cache.demo;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;

/**
 * Created by heshuanglin on 2017/11/24.
 */
public class GuavaCache {

        private LoadingCache<String,String> loadingCache ;


        public void initLoadingCache(){

            CacheLoader<String,String> cacheLoader = new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    Logger logger = LoggerFactory.getLogger("LoadingCache");
                    logger.info("LoadingCache测试 从mysql加载缓存ing...(2s)");
                    Thread.sleep(2000);
                    logger.info("LoadingCache测试 从mysql加载缓存成功");
                    System.out.println("从数据库加载数据 ："+key);
                    Thread.sleep(2000);
                    return "key";
                }
            };

            loadingCache = CacheBuilder.newBuilder().maximumSize(1).build(cacheLoader);
        }



        public String  getIfPresentloadingCache(String key){
            return loadingCache.getIfPresent(key);
        }


        public String getCacheKeyloadingCache(String key){
            try {
                return loadingCache.get(key);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        }

    //直接向缓存put数据
    public void putloadingCache(String key,String value){
        Logger logger= LoggerFactory.getLogger("LoadingCache");
        logger.info("put key :{} value : {}",key,value);
        loadingCache.put(key,value);
    }


}
