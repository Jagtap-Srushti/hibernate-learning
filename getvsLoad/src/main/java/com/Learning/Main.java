package com.Learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // ================= Configure Hibernate =================
        SessionFactory sf = new Configuration()
                .configure() // Loads hibernate.cfg.xml
                .addAnnotatedClass(com.Learning.Laptop.class) // Register Laptop entity
                .buildSessionFactory();

        // ================= Open Session =================
        Session session = sf.openSession();

        // ================= Fetching Data =================

        // ----------- get() Method -----------
        // Immediately hits the database
        // Returns actual object
        // If record not found -> returns NULL
        Laptop laptop = session.get(Laptop.class, 2);

        // ----------- load() Method -----------
        // Returns proxy object (lazy loading)
        // Does NOT hit DB immediately
        // DB query runs only when object is accessed
        // If record not found -> throws Exception (ObjectNotFoundException)
        Laptop laptop = session.load(Laptop.class, 2);

        // ----------- getReference() Method -----------
        // Similar to load() (returns proxy object)
        // Does NOT hit DB immediately
        // DB query triggers only when data is accessed
        // Throws exception if entity not found when accessed
        Laptop laptop = session.byId(Laptop.class).getReference(2);

        // Accessing object (this may trigger DB query in case of proxy)
        System.out.println(laptop);

        // ================= Close Session =================
        session.close();
        sf.close();
    }
}
