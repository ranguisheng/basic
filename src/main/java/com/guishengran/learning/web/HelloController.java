package com.guishengran.learning.web;

import com.guishengran.learning.proxy.dynamicproxy.CGLIBDynamicHelloServiceProxy;
import com.guishengran.learning.proxy.dynamicproxy.DynamicHelloServiceProxy;
import com.guishengran.learning.proxy.staticproxy.StaticHelloServiceProxy;
import com.guishengran.learning.service.IHelloService;
import com.guishengran.learning.service.Impl.HelloServiceImpl1;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    public static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Value("${${my.key}}")
    private String msg;

    @Autowired
    private StaticHelloServiceProxy staticHelloServiceProxy;

    @Autowired
    private DynamicHelloServiceProxy dynamicHelloServiceProxy;


    @Autowired
    private CGLIBDynamicHelloServiceProxy cglibDynamicHelloServiceProxy;

    @Autowired
    private IHelloService helloService;

    @Autowired
    private HelloServiceImpl1 helloServiceImpl1;

    @RequestMapping("/hello/{name}")
    @HystrixCommand(fallbackMethod = "hasError")
    public String hello(@PathVariable("name") String name){
//        int a = 20/0;
//        return "Hello,"+name;
//        return "Hello,"+msg;
//        return "Hello,"+staticHelloServiceProxy.getMsg();
//        IHelloService helloService1 = (IHelloService) dynamicHelloServiceProxy.bind(helloService);
//        return "Hello,"+helloService1.getMsg();
            CGLIBDynamicHelloServiceProxy cglibDynamicHelloServiceProxy =
                    new CGLIBDynamicHelloServiceProxy();
        HelloServiceImpl1 helloServiceImp2 =
                (HelloServiceImpl1)cglibDynamicHelloServiceProxy.getInstance(helloServiceImpl1);
            return "Hello,"+helloServiceImp2.getMsg();
    }
    public String hasError(String name){
        return "[down_level]Hello,"+name;
    }
}
