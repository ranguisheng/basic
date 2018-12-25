package com.guishengran.learning.proxy.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 基于cglib的动态代理演示对象
 * 优点:CGLIB是基于类来实现动态代理的，原理是针对指定的类生成一个子类，
 *      并覆盖其中的方法实现增强
 * 缺点：因为采用的是继承，所以不能对final修饰的类进行代理
 */
@Component
public class CGLIBDynamicHelloServiceProxy implements MethodInterceptor {
    public static final Logger logger = LoggerFactory.getLogger(CGLIBDynamicHelloServiceProxy.class);
    private Object target;
    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        logger.info("CGLIB动态代理开始事务...");
        methodProxy.invokeSuper(o,args);
        logger.info("CGLIB动态代理结束事务...");
        return null;
    }
}
