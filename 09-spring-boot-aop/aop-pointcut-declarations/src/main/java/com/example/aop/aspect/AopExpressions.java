package com.example.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
     // using @Pointcut annotation for multiple uses
    // by declaring a method with it
    // which will be used as a variable

    @Pointcut("execution(* com.example.aop.dao.*.*(..))")
    public void forDaoPackage() {}
    
    @Pointcut("execution(* com.example.aop.dao.*.get*(..))")
    public void getter() {}
    
    @Pointcut("execution(* com.example.aop.dao.*.set*(..))")
    public void setter() {}

    // exclude getter and setter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
