package org.example;

import org.example.entity.Employee;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {

//        CREATE

        Employee employee1 = new Employee("Nihir", "IT", 75000);

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.save(employee1);
        transaction.commit();
        session.close();

        System.out.println("Employee saved successfully");

//        READ

        session = HibernateUtil.getSessionFactory().openSession();
        Employee getEmployee = session.get(Employee.class, 1);
        System.out.println(getEmployee);
        session.close();

//        UPDATE

        session = HibernateUtil.getSessionFactory().openSession();
        employee1 = session.get(Employee.class, 1);
        transaction = session.beginTransaction();

        employee1.setSalary(20000);
        session.update(employee1);
        transaction.commit();
        session.close();

//        DELETE

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.delete(employee1);
        transaction.commit();
        session.close();

        System.out.println("Employee deleted successfully");
    }
}
