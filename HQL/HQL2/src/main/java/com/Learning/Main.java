package com.Learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ================= Configure Hibernate =================
        SessionFactory sf = new Configuration()
                .configure() // Loads hibernate.cfg.xml
                .addAnnotatedClass(Laptop.class) // Register Laptop entity
                .buildSessionFactory();

        // ================= Open Session =================
        Session session = sf.openSession();

        // ================= HQL with Parameter =================
        // SQL:  SELECT * FROM laptop WHERE brand = 'Asus'
        // HQL:  FROM Laptop WHERE brand = :value (or ?1)

        String brand = "Asus";

        // Selecting specific columns instead of full object
        // This returns Object[] instead of Laptop object
        Query<Object[]> query = session.createQuery(
                "select brand, model from Laptop where brand like ?1",
                Object[].class
        );

        // Setting parameter value (index starts from 1)
        query.setParameter(1, brand);

        // ================= Execute Query =================
        List<Object[]> laptops = query.getResultList();

        // ================= Process Result =================
        // Each row is Object[] -> [brand, model]
        for (Object[] data : laptops) {
            System.out.println((String) data[0] + " : " + (String) data[1]);
        }

        // Optional: print raw list
        System.out.println(laptops);

        // ================= Close Session =================
        session.close();
        sf.close();
    }
}
