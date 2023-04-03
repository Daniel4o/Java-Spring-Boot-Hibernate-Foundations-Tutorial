package com.example.springboot.thymeleafdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.entity.EmployeeDetail;
import com.example.springboot.thymeleafdemo.entity.Task;

@SpringBootApplication
public class FetchJoin {

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

			SelectionQuery<Employee> query =
				session.createSelectionQuery("SELECT i from Employee i "
										+ "JOIN FETCH i.tasks "
										+ "WHERE i.id=:employeeId",
								Employee.class);

			query.setParameter("employeeId", id);

			Employee employee = query.getSingleResult();

			System.out.println("Current Employee: " + employee);
						// Get data with lazy loading
						// using Hibernate query with HQL
		
			
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
