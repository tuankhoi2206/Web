package com.webforefront.aop;

import org.apache.openjpa.datacache.CacheStatistics;
import org.apache.openjpa.persistence.OpenJPAEntityManagerFactory;
import org.apache.openjpa.persistence.OpenJPAPersistence;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManagerFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@Aspect
public class CacheOpenJPAInterceptor {
    private Log log = LogFactory.getLog(DAOInterceptor.class);
   
   @Autowired
   private EntityManagerFactory entityManagerFactory;
   
   @Around("execution(* com.webforefront.jpa.service..*.*(..))")
   public Object log(ProceedingJoinPoint pjp) throws Throwable {      
       OpenJPAEntityManagerFactory ojpamanagerfactory = OpenJPAPersistence.cast(entityManagerFactory);
       CacheStatistics statistics = ojpamanagerfactory.getStoreCache().getStatistics();
       String str = pjp.getTarget().toString();

       log.info(str.substring(str.lastIndexOf(".")+1, str.lastIndexOf("@")) + " - " + pjp.getSignature().getName() + ": (Before call) Statistics [start time=" + statistics.start() + ",read count=" + statistics.getReadCount() + ",hit count=" + statistics.getHitCount() +",write count=" + statistics.getWriteCount() + ",total read count=" + statistics.getTotalReadCount() + ",total hit count=" + statistics.getTotalHitCount() +",total write count=" + statistics.getTotalWriteCount());
       
       Object result = pjp.proceed();

       log.info(str.substring(str.lastIndexOf(".")+1, str.lastIndexOf("@")) + " - " + pjp.getSignature().getName() + ": (After call) Statistics [start time=" + statistics.start() + ",read count=" + statistics.getReadCount() + ",hit count=" + statistics.getHitCount() +",write count=" + statistics.getWriteCount() + ",total read count=" + statistics.getTotalReadCount() + ",total hit count=" + statistics.getTotalHitCount() +",total write count=" + statistics.getTotalWriteCount());

       return result;
   } 
}