package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.aop.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    // JointPoint gives information the method thats being executed

    @Before("com.example.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=======> Executing @Before advice on method");
        
        /// Display the method signature using JoinPoint
        
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        
        System.out.println("Method: " + methodSignature);
        
        // Display method arguments using JoinPoint
        
        Object[] args = joinPoint.getArgs();

        for(Object tempArg : args) {
            System.out.println(tempArg);
        
            if(tempArg instanceof Account) {
                Account account = (Account) tempArg;

                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }

    }

}
