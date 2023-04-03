package com.example.springboot.thymeleafdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.entity.EmployeeDetail;
import com.example.springboot.thymeleafdemo.entity.Subtask;
import com.example.springboot.thymeleafdemo.entity.Task;

@SpringBootApplication
public class CreateTaskAndSubtask {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(EmployeeDetail.class)
				.addAnnotatedClass(Task.class)
				.addAnnotatedClass(Subtask.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Task task = new Task("Fix database error","Fix the error for not retrieving the neceessary records!");

			task.addSubtask(new Subtask("Look the syntax query"));
			task.addSubtask(new Subtask("Look for existing clients"));
			task.addSubtask(new Subtask("Refactor the query"));
			
			System.out.println("Saving the task");
			System.out.println(task);
			System.out.println(task.getSubtasks());

			session.persist(task);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();

			factory.close();
		}
	}

}
