package com.guishengran.service;

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
    public void execute(Long userId)
    {
        System.out.println("用户：" + userId+"，完成了注册");

        //TODO 自行业务逻辑处理
    }
}
