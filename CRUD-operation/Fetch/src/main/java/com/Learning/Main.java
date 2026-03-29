package com.Learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // This will hold fetched data from DB
        Student s2 = null;

        // Step 1: Create SessionFactory (loads config + DB setup)
        SessionFactory sf = new Configuration()
                .configure() // loads hibernate.cfg.xml
                .addAnnotatedClass(com.Learning.Student.class) // register entity
                .buildSessionFactory();

        // Step 2: Open Session (DB connection)
        Session session = sf.openSession();

        // Step 3: Fetch data using Primary Key
        // If ID exists → returns object
        // If not → returns null
        s2 = session.get(Student.class, 102);

        // Step 4: Close session (object becomes Detached state)
        session.close();

        // Close SessionFactory
        sf.close();

        // Print fetched object
        System.out.println(s2);
    }
}
