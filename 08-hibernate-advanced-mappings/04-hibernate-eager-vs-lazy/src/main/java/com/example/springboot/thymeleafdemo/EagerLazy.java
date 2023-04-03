package com.example.springboot.thymeleafdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.entity.EmployeeDetail;
import com.example.springboot.thymeleafdemo.entity.Task;

@SpringBootApplication
public class EagerLazy {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(EmployeeDetail.class)
				.addAnnotatedClass(Task.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int id = 1;
			Employee employee = session.get(Employee.class, id);

			System.out.println("Current Employee: " + employee);
						// Get data with lazy loading
						// using getter method while session is open
		
			System.out.println("Current Tasks: "+ employee.getTasks());
			
			session.getTransaction().commit();
			session.close();
			
			System.out.println("\nThe session is now closed!\n");
			System.out.println("Current Tasks: "+ employee.getTasks());
			
			System.out.println("Done!");
		} finally {
			session.close();

			factory.close();
		}
	}

}
