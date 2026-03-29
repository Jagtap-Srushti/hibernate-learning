package com.Learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // ================= Create Laptop Objects =================
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("ROG");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("MacBook Air");
        l3.setRam(8);

        // ================= Create Programmer Objects =================
        Programmer p1 = new Programmer();
        p1.setPid(101);
        p1.setPname("ABC");
        p1.setTech("Java");

        Programmer p2 = new Programmer();
        p2.setPid(102);
        p2.setPname("PQR");
        p2.setTech("Python");

        Programmer p3 = new Programmer();
        p3.setPid(103);
        p3.setPname("XYZ");
        p3.setTech("AI");

        // ================= Establish Many-to-Many Relationships =================
        // Assign laptops to programmers
        p1.setLaptops(Arrays.asList(l1, l2));
        p2.setLaptops(Arrays.asList(l2, l3));
        p3.setLaptops(Arrays.asList(l1));

        // Assign programmers to laptops
        l1.setProgrammers(Arrays.asList(p1, p3));
        l2.setProgrammers(Arrays.asList(p1, p2));
        l3.setProgrammers(Arrays.asList(p2));

        // ================= Configure Hibernate =================
        SessionFactory sf = new Configuration()
                .configure() // Reads hibernate.cfg.xml
                .addAnnotatedClass(com.Learning.Programmer.class) // Register Programmer entity
                .addAnnotatedClass(com.Learning.Laptop.class)     // Register Laptop entity
                .buildSessionFactory();

        Session session = sf.openSession();

        // ================= Begin Transaction =================
        Transaction transaction = session.beginTransaction();

        // ================= Persist Laptops =================
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        // ================= Persist Programmers =================
        session.persist(p1);
        session.persist(p2);
        session.persist(p3);

        // ================= Commit Transaction =================
        transaction.commit();

        // ================= Fetch and Print Programmer =================
        Programmer p = session.get(Programmer.class, 102);
        System.out.println(p); // Will print programmer with associated laptops

        // ================= Close Session & SessionFactory =================
        session.close();
        sf.close();
    }
}
