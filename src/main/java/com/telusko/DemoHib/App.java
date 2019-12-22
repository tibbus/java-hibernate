package com.telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
        Alien telusko = new Alien();

        AlienName an = new AlienName();
        an.setFname("Tiberiu");
        an.setLname("Popescu");
        an.setMname("Raul");

        telusko.setAid(110);
        telusko.setAname(an);
        telusko.setColor("Green");

        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

//        ServiceRegistry reg = new SessionFactoryServiceRegistryBuilder.appl(con.getProperties());

        ServiceRegistry reg = new StandardServiceRegistryBuilder().
                applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory(reg);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(telusko);

        telusko = session.get(Alien.class, 101);

        tx.commit();

        System.out.println(telusko);
    }
}
