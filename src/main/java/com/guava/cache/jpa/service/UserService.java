package com.guava.cache.jpa.service;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.hash.BloomFilter;
import com.guava.cache.jpa.dao.UserRepository;
import com.guava.cache.jpa.model.User;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Nullable;
import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshuanglin on 2018/4/25.
 */
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource(name="getRedisTemplate")
    private RedisTemplate redisTemplate;

    private LoadingCache<String,User> loadingCache;


    private static final String USER_ID = "user:%s";


    private Cache<String,User> cache = CacheBuilder.newBuilder().recordStats().expireAfterAccess(3,TimeUnit.SECONDS)
                                        .expireAfterWrite(5,TimeUnit.SECONDS).maximumSize(5).weakValues().build();

    {
        loadingCache = CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.SECONDS).build(new CacheLoader<String, User>() {
            @Override
            public User load(String name) throws Exception {
                return userRepository.findByName(name);
            }
        });
    }

    public List<User> findAll(){
        return  userRepository.findAll();
    }


    public User findByName(String name) throws ExecutionException {
        cache.get(name, new Callable<User>() {
            @Override
            public User call() throws Exception {
                return userRepository.findByName(name);
            }
        });
        System.out.println("cache.getIfPresent(name) :"+cache.getIfPresent(name));
        User user = loadingCache.get(name);
//        cache.put(name,user);
        return user;
    }


    public Optional<User> findById(int id){
        String key = String.format(USER_ID,id);
        System.out.println("用户key :"+key);
        HashOperations operations =  redisTemplate.opsForHash();
        Long old = (Long) operations.get(key,"id");


        User user = userRepository.findById(id);

        operations.put(key,"id",user.getId());

        Preconditions.checkArgument(true,"条件不满足");
        System.out.println("user :"+user);
        return  Optional.fromNullable(user);
    }



}
