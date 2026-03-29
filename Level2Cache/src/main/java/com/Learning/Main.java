package com.Learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // ================= Configure Hibernate =================
        // SessionFactory is shared across sessions
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        // ================= First Session =================
        Session session = sf.openSession();

        // First time fetching -> hits DATABASE
        Laptop l1 = session.get(Laptop.class, 2);
        System.out.println(l1);

        session.close(); // First-level cache is cleared here

        // ================= Second Session =================
        Session session1 = sf.openSession();

        // Fetching same object again
        // If Level 2 Cache is ENABLED → data comes from cache (NO DB hit)
        // If NOT enabled → again hits DATABASE
        Laptop l2 = session1.get(Laptop.class, 2);
        System.out.println(l2);

        session1.close();

        // ================= Close SessionFactory =================
        sf.close();
    }
}
