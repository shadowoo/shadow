package com.guava.cache.springSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * Created by heshuanglin on 2017/11/30.
 */
@Configuration
public class SpringSessionConfig {

    @Bean
    public CookieHttpSessionStrategy  cookieHttpSessionStrategy(){
        CookieHttpSessionStrategy strategy=new CookieHttpSessionStrategy();
        DefaultCookieSerializer  cookieSerializer = new DefaultCookieSerializer();
        cookieSerializer.setCookieName("MYSESSIONID");//cookies名称
        cookieSerializer.setCookieMaxAge(1800);//过期时间(秒)
        strategy.setCookieSerializer(cookieSerializer);
        return strategy;
    }
}
