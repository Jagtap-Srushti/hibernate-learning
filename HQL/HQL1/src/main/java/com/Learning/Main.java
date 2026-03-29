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

        // ================= HQL Example =================
        // SQL:  Select * from laptop where ram = 32
        // HQL:  from Laptop where ram = 32
        // Note: HQL uses class name (Laptop), not table name

        Query<Laptop> query = session.createQuery("from Laptop where ram = 32", Laptop.class);

        // Execute query and fetch results
        List<Laptop> laptops = query.getResultList();

        // ================= Print Result =================
        System.out.println(laptops);

        // ================= Close Session =================
        session.close();
        sf.close();
    }
}
