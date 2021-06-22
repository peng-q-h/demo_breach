package com.xyhj.demo.aspect;

import com.xyhj.demo.annotation.PassAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @author Andy
 * @title: LogAspect
 * @description:
 * @date 2020/6/21 16:05
 */
@Slf4j
@Aspect
@Order(-1)
@Component
public class AutoLogAspect {

    private static String EXECUTION = "execution";
    
    @Pointcut("execution (* com.xyhj.demo.demo.*.*(..))")
    public void automaticCut() {
    }


//    @Around("@annotation(logAn)")
//    public Object logSave(ProceedingJoinPoint joinPoint, LogAnnotation logAn) throws Throwable {

    /**
     * method:
     * description:
     *
     * @param joinPoint
     * @return
     * @author Andy
     * @data 2020/7/3 15:35
     */
    @Around("automaticCut()")
    public Object Save(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        PassAspect passAspect = signature.getMethod().getDeclaredAnnotation(PassAspect.class);
        if (passAspect == null) {
            joinPoint.proceed();
        }
        String value = passAspect.value();
        
        if (EXECUTION.equals(value)) {
            System.out.println("读取了注解中的值");
        }
        return value;
    }
    
    

 

    

}
