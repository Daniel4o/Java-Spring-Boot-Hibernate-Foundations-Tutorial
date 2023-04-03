package com.example.springboot.thymeleafdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.entity.EmployeeDetail;

@SpringBootApplication
public class DeleteEmployeeDetail {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(EmployeeDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 5;
            EmployeeDetail employeeDetail = session.get(EmployeeDetail.class, id);
            System.out.println("EmployeeDetil: " + employeeDetail);
            System.out.println("The associated employee: " + employeeDetail.getEmployee());

            System.out.println("Deleting employeeDetail: " + employeeDetail);
          
            // for deleting ONLY employeeDetail
            // remove the associated object reference
            // break bi-directional link
            employeeDetail.getEmployee().setEmployeeDetail(null);
            
            session.remove(employeeDetail);
            session.getTransaction().commit();
        } 
        catch (Exception exc) {
            exc.printStackTrace();
        } 
        finally {
            session.close();
            factory.close();
        }
    }

}
