package com.Learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // ================= Create Laptop Object =================
        // This object will be embedded in Programmer entity
        Laptop l1 = new Laptop();
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);

        // ================= Create Programmer Object =================
        // Here we are using the Programmer entity
        Programmer p1 = new Programmer();
        p1.setPid(101);           // Set primary key
        p1.setPname("ABC");       // Set programmer name
        p1.setTech("Java");       // Set technology
        p1.setLaptop(l1);         // Embed Laptop object into Programmer

        // ================= Create Hibernate SessionFactory =================
        // SessionFactory is used to create sessions with database
        SessionFactory sf = new Configuration()
                .configure()                       // Reads hibernate.cfg.xml
                .addAnnotatedClass(Programmer.class) // Registers Programmer entity
                .buildSessionFactory();

        // ================= Open Hibernate Session =================
        Session session = sf.openSession();

        // ================= Begin Transaction =================
        Transaction transaction = session.beginTransaction();

        // ================= Save Programmer Object =================
        // Since Laptop is @Embeddable, its fields will be saved inside Programmer table
        session.persist(p1);

        // ================= Commit Transaction =================
        transaction.commit();

        // ================= Fetch Programmer Object from DB =================
        // Using primary key to fetch object
        Programmer a2 = session.get(Programmer.class, 101);
        System.out.println(p2);  // Prints Programmer along with embedded Laptop

        // ================= Close Session & SessionFactory =================
        session.close();
        sf.close();//session factory closed
    }
}
