package com.Learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // Creating Student object (POJO class mapped to DB table)
        Student s1 = new Student();

        // Setting values (this data will be inserted into DB)
        s1.setRollNo(101);
        s1.setsName("Avni");
        s1.setsAge(20);

        // Step 1: Create SessionFactory (Heavy object, created only once)
        // It reads hibernate.cfg.xml and sets up DB connection
        SessionFactory sf = new Configuration()
                .configure() // loads hibernate.cfg.xml by default
                .addAnnotatedClass(com.Learning.Student.class) // register entity class
                .buildSessionFactory();

        // Step 2: Open Session (like a connection to DB)
        Session session = sf.openSession();

        // Step 3: Begin Transaction (required for DB operations)
        Transaction transaction = session.beginTransaction();

        // Step 4: Persist object (INSERT operation)
        // Converts Java object -> Database row
        session.persist(s1);

        // Step 5: Commit Transaction (executes SQL query in DB)
        transaction.commit();

        // Step 6: Close session (release DB resources)
        session.close();

        // Step 7: Close SessionFactory (application shutdown)
        sf.close();

        // Printing object (will use toString() method of Student class)
        System.out.println(s1);
    }
}
