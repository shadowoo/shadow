package com.guava.cache.redis;

import org.springframework.stereotype.Component;

/**
 * Created by heshuanglin on 2018/4/28.
 */
@Component
public class MessageReceiver {

    /**接收消息的方法*/
    public void receiveMessage(String message){
        System.out.println("收到一条消息："+message);
    }
}
