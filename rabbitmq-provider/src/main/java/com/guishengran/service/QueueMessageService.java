package com.guishengran.service;

import com.guishengran.enums.ExchangeEnum;
import com.guishengran.enums.QueueEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @Auther: guish
 * @Date: 2018/12/26 07:59
 * @Description:
 */
public interface QueueMessageService extends RabbitTemplate.ConfirmCallback{
    /**
     * 发送消息到rabbitmq消息队列
     * @param message 消息内容
     * @param exchangeEnum 交换配置枚举
     * @param queueEnum 队列配置枚举
     * @throws Exception
     */
    public void send(Object message, ExchangeEnum exchangeEnum, QueueEnum queueEnum) throws Exception;
}
