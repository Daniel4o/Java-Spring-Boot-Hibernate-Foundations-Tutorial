package com.example.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.aop.entity.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    // Add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(pointcut = "execution(* com.example.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint joinPoint, List<Account> result) {

        // Print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        // Print out the results of the method call
        System.out.println("\n=====>>> result is: " + result);

        // Post-process the data by modifying it
        // convert account names to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("\n=====>>> result is: " + result);
    }

    // JoinPoint gives information the method thats being executed

    private void convertAccountNamesToUpperCase(List<Account> result) {
        result.forEach(account -> account.setName(account.getName().toUpperCase()));
    }

}
