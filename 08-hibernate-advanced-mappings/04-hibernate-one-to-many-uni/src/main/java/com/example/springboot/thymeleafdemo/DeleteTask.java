package com.example.springboot.thymeleafdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.entity.EmployeeDetail;
import com.example.springboot.thymeleafdemo.entity.Task;

@SpringBootApplication
public class DeleteTask {

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

			int id = 10;
			Task task = session.get(Task.class, id);

			System.out.println("Deleting task: " + task);

			session.remove(task);
			
			session.getTransaction().commit();
		} finally {
			session.close();

			factory.close();
		}
	}

}
