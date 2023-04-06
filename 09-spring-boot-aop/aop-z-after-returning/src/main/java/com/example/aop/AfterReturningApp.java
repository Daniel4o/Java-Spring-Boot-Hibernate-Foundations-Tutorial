package com.example.aop;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aop.dao.AccountDAO;
import com.example.aop.entity.Account;

@SpringBootApplication
public class AfterReturningApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(Config.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("\n\nMain Program: AfterReturningApp");
		System.out.println("----");
		System.out.println(accounts);
		System.out.println("\n");

		context.close();

	}

}
