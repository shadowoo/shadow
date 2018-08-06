package com.guava.cache.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by heshuanglin on 2018/4/28.
 */
@EnableScheduling //开启定时器功能
@Component
public class MessageSender {

    @Resource(name="getRedisTemplate")
    private RedisTemplate redisTemplate;

    @Scheduled(fixedRate = 2000) //间隔2s 通过StringRedisTemplate对象向redis消息队列chat频道发布消息
    public void sendMessage(){
        redisTemplate.convertAndSend("chat",String.valueOf(Math.random()));
    }

}
