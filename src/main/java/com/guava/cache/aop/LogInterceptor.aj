package com.guava.cache.aop;

import com.guava.cache.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by heshuanglin on 2017/12/4.
 */
@Aspect
@Component
public class LogInterceptor {

    @Pointcut(value = "@annotation(com.guava.cache.annotation.Log)")
    public void myInterceptor() {
        System.out.println("拦截到Log注解");
    }
    // 用@Pointcut来注解一个切入方法
    @Pointcut("execution(* com.guava.cache.swagger2..*.*(..))")
    public void excudeController() {
    }

    @Around(value ="myInterceptor()&&excudeController()&&@annotation(annotation)")
    public Object twiceAsOld(ProceedingJoinPoint thisJoinPoint,
                             Log annotation
    ) {
        System.out.println("拦截到Log注解----------");

        return null;
    }



    @Around(value = "@annotation(com.guava.cache.annotation.Log)")
    public void logInfo(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("拦截到Log注解");
        joinPoint.proceed();
    }


//    @Before(value = "execution(* com.guava.cache.swagger2..*.*(..))")
//    public  void beforeLog(JoinPoint joinPoint){
//        System.out.println("拦截到Log注解----------");
//    }

    @Before(value = "execution(String com.guava.cache.swagger2.Swagger2Controller.test(*,*))")
    public void before(){
        System.out.println("拦截到Log注解----------222222222222222222");
    }

    @Before(value = "execution(String com.guava.cache.swagger2.Swagger2Controller.testLog())")
    public void beforei(){
        System.out.println("拦截到Log注解----------333333333333333333");
    }


    @Pointcut("@annotation(com.guava.cache.annotation.Log)")
    public void webLog(){

    }


    @Before("webLog()")
    public  void beforeLog(JoinPoint joinPoint){
        System.out.println("拦截到Log注解----------");
    }


    @Before(value = "execution(* com.guava.cache.swagger2..*.*(..))")
    public  void before_Log(JoinPoint joinPoint){
        System.out.println("AOP拦截----------");
    }
}
