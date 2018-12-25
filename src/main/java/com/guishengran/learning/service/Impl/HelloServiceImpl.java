package com.guishengran.learning.service.Impl;

import com.guishengran.learning.service.IHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements IHelloService {
    public static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);
    @Override
    public String getMsg() {
        logger.info("do getMsg()");
        return "WORLD";
    }
}
