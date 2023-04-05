package com.example.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

   // @Before("execution(public void addAccount())")
   // @Before("execution(public void com.example.aop.dao.AccountDAO.addAccount())")
   // @Before("execution(public void add*())")
   // @Before("execution(void add*())")
   // @Before("execution(* add*())")
   
  //  @Before("execution(* add*(com.example.aop.Account))")
  //  @Before("execution(* add*(com.example.aop.Account))")
  //  @Before("execution(* add*(com.example.aop.Account, boolean))")
  // ..- Matching 0 or more params
  //  @Before("execution(* add*(com.example.aop.Account, ..))")
  //  @Before("execution(* add*(..))")

  // Matching on any return type on the dao package
  // Matching on any class in the dao package
  // Matching on any method in dao package
  // Matching on 0 or more params
    @Before("execution(* com.example.aop.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=======> Executing @Before advice on method");
    }
}
