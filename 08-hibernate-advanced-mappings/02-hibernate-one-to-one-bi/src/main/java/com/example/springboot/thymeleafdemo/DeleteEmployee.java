package com.example.springboot.thymeleafdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.entity.EmployeeDetail;

@SpringBootApplication
public class DeleteEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(EmployeeDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int id = 3;
			Employee employee = session.get(Employee.class, id);
			System.out.println("Found Employee: " + employee);
			
			if (employee != null) {
				System.out.println("Deleting: " + employee);
				session.remove(employee);
			}

			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
