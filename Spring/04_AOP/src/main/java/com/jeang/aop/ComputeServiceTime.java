package com.jeang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ComputeServiceTime {
    @Pointcut("execution(* com.jeang.service.*.*Service(..))")
    private void pt() {
    }

    @Around("pt()")
    public void ten_thousand_time(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            pjp.proceed();
        }
        long end = System.currentTimeMillis();
        System.out.println(signature.getName() + " execution time: ---> " + (end - start) + "ms");
    }
}
