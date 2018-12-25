package com.guishengran.learning.proxy.staticproxy;

import com.guishengran.learning.service.IHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 静态代理演示类：
 * 优点：代码好理解
 * 代理的创建时期：程序员创建或者由特定的工具自动生成，此处为程序员创建
 * 缺点：每一个代理类只能服务一个接口，这样当项目里势必会有很多的代理，而且，
 *  所有的代理，除了调用方法不一样以外，其他的地方都一样，此时，肯定是重复的代码，
 *  解决这个问题最好是通过一个全局的代理类完成全局的代理，这就是动态代理
 */
@Component
public class StaticHelloServiceProxy implements IHelloService{
    public static final Logger logger = LoggerFactory.getLogger(StaticHelloServiceProxy.class);
    @Autowired
    IHelloService helloService;

    @Override
    public String getMsg() {
        logger.info("before do getMsg()");
        String str = helloService.getMsg();
        logger.info("after do getMsg()");
        return str;
    }
}
