package com.spring.util;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger2 {

    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("Logger2.beforePrintLog2执行了");
    }
    /**
     * 后置通知
     */
    public void afterReturningPrintLog() {
        System.out.println("Logger.afterReturningPrintLog执行了");
    }
    /**
     * 异常通知
     */
    public void afterThrowingPrintLog() {
        System.out.println("Logger.afterThrowingPrintLog执行了");
    }
    /**
     * 最终通知
     */
    public void afterPrintLog() {
        System.out.println("Logger.afterPrintLog执行了");
    }

    /**
     * 环绕通知
     */
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
