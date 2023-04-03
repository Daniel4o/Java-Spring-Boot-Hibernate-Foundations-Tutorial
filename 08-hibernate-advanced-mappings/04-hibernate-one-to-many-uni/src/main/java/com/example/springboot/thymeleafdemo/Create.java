package com.example.springboot.thymeleafdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.entity.EmployeeDetail;

@SpringBootApplication
public class Create {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(EmployeeDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			Employee saveEmployee = new Employee("Nick", "Johnson", "nick.ss@gmail.com", 8, "DAN40NICKE");
			EmployeeDetail employeeDetail = new EmployeeDetail("nick.com", "Cycling");

			saveEmployee.setEmployeeDetail(employeeDetail);

			session.beginTransaction();
			session.persist(saveEmployee);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
