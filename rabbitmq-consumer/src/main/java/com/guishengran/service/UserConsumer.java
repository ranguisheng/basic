package com.guishengran.service;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: guish
 * @Date: 2018/12/26 08:17
 * @Description:
 */
@Component
@RabbitListener(queues = "user.register.queue")
public class UserConsumer {
    @RabbitHandler
    public void execute(Object userEntity)
    {
        System.out.println("消费者接受到消息："+ JSON.toJSONString(userEntity));

        //TODO 自行业务逻辑处理
    }
}
