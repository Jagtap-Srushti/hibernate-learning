package com.Learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // ------------------ Creating Laptop Objects ------------------
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

        // ------------------ Creating Programmer Objects ------------------
        Programmer p1 = new Programmer();
        p1.setPid(101);
        p1.setPname("ABC");
        p1.setTech("Java");

        Programmer p2 = new Programmer();
        p2.setPid(102);
        p2.setPname("XYZ");
        p2.setTech("Python");

        // ------------------ Configure Hibernate ------------------
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Programmer.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        // ------------------ Begin Transaction ------------------
        Transaction transaction = session.beginTransaction();

        // Save laptops
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        // Save programmers
        session.persist(p1);
        session.persist(p2);

        // ------------------ Commit Transaction ------------------
        transaction.commit();

        session.close();

        // ------------------ Fetching Data ------------------
        Session session1 = sf.openSession();

        // ================= LAZY vs EAGER Fetching =================

        // Fetch Programmer object from DB
        Programmer p = session1.get(Programmer.class, 101);

        // ----------- EAGER Fetching -----------
        // Data (like laptops) is loaded immediately along with Programmer
        // Even if you don't use laptops, Hibernate fetches it

        // ----------- LAZY Fetching -----------
        // Data is NOT loaded initially
        // It loads only when you call or use it
        // p.getLaptops()


        System.out.println(p);

        session1.close();
        sf.close();
    }
}
