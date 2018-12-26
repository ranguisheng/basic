package com.guishengran.enums;

import lombok.Getter;

/**
 * @Auther: guish
 * @Date: 2018/12/26 08:05
 * @Description:
 */
@Getter
public enum QueueEnum {
    /**
     * 用户注册枚举
     */
    USER_REGISTER("user.register.queue","user.register")
    ;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 队列路由键
     */
    private String routingKey;

    QueueEnum(String name, String routingKey) {
        this.name = name;
        this.routingKey = routingKey;
    }
}
