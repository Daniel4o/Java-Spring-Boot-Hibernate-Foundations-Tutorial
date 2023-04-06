package com.example.aop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aop.dao.AccountDAO;
import com.example.aop.dao.MembershipDAO;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(Config.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

		Account account = new Account();
		account.setName("Daniel");
		account.setLevel("Platinum");
		accountDAO.addAccount(account, true);
		membershipDAO.addAccount();

		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		accountDAO.doWork();
		membershipDAO.goToSleep();

		context.close();

	//	SpringApplication.run(AopApplication.class, args);
	}

}
