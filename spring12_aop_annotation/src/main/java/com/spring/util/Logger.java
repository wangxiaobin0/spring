package com.spring.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {

    @Pointcut("execution(* com.spring.service.impl.*.*(..))")
    private void pt() {}
    /**
     * 前置通知
     */
    @Before("pt()")
    public void beforePrintLog() {
        System.out.println("前置通知");
    }
    /**
     * 后置通知
     */
    @AfterReturning("pt()")
    public void afterReturningPrintLog() {
        System.out.println("后置通知");
    }
    /**
     * 异常通知
     */
    @AfterThrowing("pt()")
    public void afterThrowingPrintLog() {
        System.out.println("异常通知");
    }
    /**
     * 最终通知
     */
    @After("pt()")
    public void afterPrintLog() {
        System.out.println("最终通知");
    }

    /**
     * 环绕通知
     */
    @Around("pt()")
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint) {
        Object retValue = null;
        try {
            Object[] args = proceedingJoinPoint.getArgs();
            retValue = proceedingJoinPoint.proceed(args);
            return retValue;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        } finally {

            System.out.println("环绕通知");
        }
    }
}
