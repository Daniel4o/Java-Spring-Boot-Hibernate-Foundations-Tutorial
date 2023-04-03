package com.example.springboot.thymeleafdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.entity.EmployeeDetail;

@SpringBootApplication
public class ThymeleafdemoApplication {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
		.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.addAnnotatedClass(EmployeeDetail.class)
								.buildSessionFactory();		
		
		Session session = factory.getCurrentSession();

		try {
		 	 Employee saveEmployee = new Employee("Nick","Johnson","nick.ss@gmail.com",8,"DAN40NICKE");
			EmployeeDetail employeeDetail = new EmployeeDetail("nick.com","Cycling");
			
			saveEmployee.setEmployeeDetail(employeeDetail);
			 
session.beginTransaction();

	session.persist(saveEmployee);
			int id = 3;
			Employee employee = session.get(Employee.class,id);
			System.out.println("Found Employee: " + employee);
			if(employee != null) {
				System.out.println("Deleting: " + employee);
				session.remove(employee);
			}

			
			session.getTransaction().commit();
		} 
		finally {
			factory.close();
			SpringApplication.run(ThymeleafdemoApplication.class, args);
		}	

		
	}

}
