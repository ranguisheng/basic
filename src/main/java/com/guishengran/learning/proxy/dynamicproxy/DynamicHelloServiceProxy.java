package com.guishengran.learning.proxy.dynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理演示类
 * 优点：相比静态代理，不用重复的写很多代理类，一个代理代理了很多接口
 *       jdk动态代理是针对类来实现代理的
 * 缺点：jdk的动态代理是基于java的interface，必须实现接口，还是会有一些限制，
 * 比如我们想要动态代理一组对象的行为，但是这组对象都没有或者部分并没有实现任何接口
 * 这个时候基于JDK反射的动态代理就不能满足我们的要求了，这个时候就需要基于CGIG的代码生成的代理
 */
@Component
public class DynamicHelloServiceProxy implements InvocationHandler{
    public static final Logger logger = LoggerFactory.getLogger(DynamicHelloServiceProxy.class);
    private Object target;
    public Object bind(Object target){
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       Object result = null;
       logger.info("动态代理事务开始...");
       result = method.invoke(target,args);
       logger.info("动态代理事务结束...");
       return result;
    }
}
