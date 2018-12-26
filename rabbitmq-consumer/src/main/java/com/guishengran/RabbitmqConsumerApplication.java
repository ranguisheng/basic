package com.guishengran;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: guish
 * @Date: 2018/12/26 08:13
 * @Description:
 */
@SpringBootApplication
public class RabbitmqConsumerApplication {
    static Logger logger = LoggerFactory.getLogger(RabbitmqConsumerApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumerApplication.class,args);
        logger.info("【【【【【消息队列-消息消费者启动成功.】】】】】");
    }
}
