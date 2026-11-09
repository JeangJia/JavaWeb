package com.jeang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    //    @Pointcut("execution(void com.jeang.dao.BookDao.update())")
    @Pointcut("execution(* com.jeang.dao.BookDao.save())")
    private void pt() {
    }

    @Pointcut("execution(int com.jeang.dao.BookDao.update())")
    private void pt2() {
    }

    @Before("pt()")
    public void before() {
        System.out.println("Before running...");
    }

    @After("pt()")
    public void after() {
        System.out.println("After running...");
    }

    @Around("pt()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around before running...");
        pjp.proceed();
        System.out.println("Around after running...");
    }

    @Around("pt2()")
    public Object around2(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around2 before running...");
        Object ret = pjp.proceed();
        System.out.println("Around2 after running...");
        return ret;
    }
}
