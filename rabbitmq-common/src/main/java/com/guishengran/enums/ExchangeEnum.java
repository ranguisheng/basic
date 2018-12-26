package com.guishengran.enums;

import lombok.Getter;

/**
 * @Auther: guish
 * @Date: 2018/12/26 08:04
 * @Description:
 */
@Getter
public enum ExchangeEnum {
    /**
     * 用户注册交换配置枚举
     */
    USER_REGISTER("user.register.topic.exchange");
    private String value;

    ExchangeEnum(String value) {
        this.value = value;
    }
}
