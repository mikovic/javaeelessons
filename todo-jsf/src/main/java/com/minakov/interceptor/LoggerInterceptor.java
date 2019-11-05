package com.minakov.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

public class LoggerInterceptor implements Serializable {
    private static final Logger logger =
            LoggerFactory.getLogger(LoggerInterceptor.class.getName());
    @AroundInvoke
    public Object printLog(InvocationContext ctx) throws Exception{
        logger.debug("Перехватчик до вызова метода!!!!!!!!!!: "
                + ctx.getMethod().getName());
        Object result = ctx.proceed();
        logger.debug("Перехватчик после вызова метода: " + ctx.getMethod().getName());
        return result;
    }
}

