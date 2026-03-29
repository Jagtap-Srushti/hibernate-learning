package com.Learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // Creating reference object (will be used to fetch data)
        Student s1 = new Student();

        // Step 1: Create SessionFactory (loads configuration + DB connection setup)
        SessionFactory sf = new Configuration()
                .configure() // loads hibernate.cfg.xml
                .addAnnotatedClass(com.Learning.Student.class) // register entity
                .buildSessionFactory();

        // Step 2: Open Session (connection with DB)
        Session session = sf.openSession();

        // Step 3: Fetch object from DB using Primary Key
        // If record exists → returns object
        // If not → returns null
        s1 = session.get(Student.class, 109);

        // Step 4: Begin Transaction (required for delete operation)
        Transaction transaction = session.beginTransaction();

        // Step 5: Remove/Delete object from DB
        // Hibernate converts this into DELETE SQL query
        session.remove(s1);

        // Step 6: Commit Transaction (executes DELETE query)
        transaction.commit();

        // Step 7: Close session and factory
        session.close();
        sf.close();

        // Printing deleted object details
        System.out.println(s1);
    }
}
