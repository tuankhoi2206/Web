package com.webforefront.aop;

import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
public class DAOInterceptor {
    private Log log = LogFactory.getLog(DAOInterceptor.class);
    
    @Around("execution(* com.webforefront.jpa.service..*.*(..))")
    public Object logQueryTimes(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object retVal = pjp.proceed();
        stopWatch.stop();
        String str = pjp.getTarget().toString();
        log.info(str.substring(str.lastIndexOf(".")+1, str.lastIndexOf("@")) + " - " + pjp.getSignature().getName() + ": " + stopWatch.getTime() + "ms");
        return retVal;
    }
}
