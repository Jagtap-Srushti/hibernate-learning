package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // ================= Create Programmer Object =================
        // Create an instance of Programmer and set its fields
        Programmer p1 = new Programmer();
        p1.setPid(101);           // Set primary key
        p1.setPname("ABC");     // Set programmer name
        p1.setTech("Java");       // This field is @Transient, so it won't be saved in DB

        // ================= Create Hibernate SessionFactory =================
        // SessionFactory is used to create sessions and manage DB connection
        SessionFactory sf = new Configuration()
                .configure()                      // Reads hibernate.cfg.xml
                .addAnnotatedClass(Programmer.class) // Register Programmer entity
                .buildSessionFactory();

        // ================= Open Hibernate Session =================
        Session session = sf.openSession();

        // ================= Begin Transaction =================
        Transaction transaction = session.beginTransaction();

        // ================= Save Programmer Object =================
        // Persist the Programmer object to the database
        session.persist(p1);

        // ================= Commit Transaction =================
        transaction.commit();

        // ================= Close Session & SessionFactory =================
        session.close();
        sf.close();

        // ================= Optional: Print Object =================
        System.out.println("Programmer saved: " + p1);
    }
}
