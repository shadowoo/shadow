package com.guava.cache.redis;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by heshuanglin on 2017/11/30.
 */
@Configuration
@EnableAutoConfiguration
public class RedisConfig {

    private  static Logger  logger = Logger.getLogger(RedisConfig.class);

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        return  jedisPoolConfig;
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory getConnectFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        JedisPoolConfig config = getRedisConfig();
        factory.setPoolConfig(config);
        System.out.println("JedisConnectionFactory bean init success.");
        logger.info("JedisConnectionFactory bean init success.");
        return  factory;
    }

    @Bean
    public RedisTemplate<?,?> getRedisTemplate(){
        RedisTemplate<?,?> template = new StringRedisTemplate();

        template.setConnectionFactory(getConnectFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new EntityRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        template.setEnableTransactionSupport(true);
        return  template;
    }


//    @Bean
//    public RedisMessageListenerContainer container(MessageListenerAdapter listenerAdapter){
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(getConnectFactory());
//        container.addMessageListener(listenerAdapter,new PatternTopic("chat"));
//        return container;
//    }
//
//
//    @Bean
//    public MessageListenerAdapter listenerAdapter(MessageReceiver receiver){
//        return  new MessageListenerAdapter(receiver,"receiveMessage");
//    }
}
