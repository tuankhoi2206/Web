package com.webforefront.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@Aspect
public class CacheEclipseLinkInterceptor {
    private Log log = LogFactory.getLog(DAOInterceptor.class);
   
   @Autowired
   private EntityManagerFactory entityManagerFactory;
   
   @Around("execution(* com.webforefront.jpa.service..*.*(..))")
   public Object log(ProceedingJoinPoint pjp) throws Throwable {     
       // EclipseLink Profiler already activate in persistence.xml
       Object result = pjp.proceed();
       return result;
   } 
}