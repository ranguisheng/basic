package com.guishengran.learning.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl1 {
    public static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl1.class);
    public String getMsg() {
        logger.info("do getMsg()");
        return "WORLD";
    }
}
