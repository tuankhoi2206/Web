package com.webforefront.aop;

import org.hibernate.stat.Statistics;
import org.hibernate.SessionFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManagerFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@Aspect
public class CacheHibernateInterceptor {
    private Log log = LogFactory.getLog(DAOInterceptor.class);
   
   @Autowired
   private EntityManagerFactory entityManagerFactory;
   
   @Around("execution(* com.webforefront.jpa.service..*.*(..))")
   public Object log(ProceedingJoinPoint pjp) throws Throwable {      
       HibernateEntityManagerFactory hbmanagerfactory = (HibernateEntityManagerFactory) entityManagerFactory;
       SessionFactory sessionFactory = hbmanagerfactory.getSessionFactory();
       Statistics statistics = sessionFactory.getStatistics();
       String str = pjp.getTarget().toString();
       statistics.setStatisticsEnabled(true);
       log.info(str.substring(str.lastIndexOf(".")+1, str.lastIndexOf("@")) + " - " + pjp.getSignature().getName() + ": (Before call) " + statistics);
       
       Object result = pjp.proceed();

       log.info(str.substring(str.lastIndexOf(".")+1, str.lastIndexOf("@")) + " - " + pjp.getSignature().getName() + ": (After call) " + statistics);

       //log.info(String.format("CACHE HIT; Ratio=%s; Signature=%s#%s()", NF.format(ratio), pjp.getTarget().getClass().getName(), pjp.getSignature().toShortString()));
       return result;
   } 
}