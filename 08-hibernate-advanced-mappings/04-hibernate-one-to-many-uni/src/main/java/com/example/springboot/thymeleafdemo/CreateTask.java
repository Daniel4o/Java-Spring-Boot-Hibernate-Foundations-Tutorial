package com.example.springboot.thymeleafdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.entity.EmployeeDetail;
import com.example.springboot.thymeleafdemo.entity.Task;

@SpringBootApplication
public class CreateTask {

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

			Task task1 = new Task("Add documentation", "Add documentation for the project");
			Task task2 = new Task("Edit database", "Edit the employee code for the existing employees");

			employee.add(task1);
			employee.add(task2);

			session.persist(task1);
			session.persist(task2);

			session.getTransaction().commit();
		} finally {
			session.close();

			factory.close();
		}
	}

}
