package com.telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");

        Student student = new Student();
        student.setName("Navin");
        student.setRollno(1);
        student.setMarks(50);

        student.getLaptops().add(laptop);
        laptop.getStudents().add(student);

        Configuration con = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().
                applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(registry);
        Session session = sf.openSession();

        session.beginTransaction();

        session.save(laptop);
        session.save(student);
// git test gg hh  66
        session.getTransaction().commit();
    }
}
