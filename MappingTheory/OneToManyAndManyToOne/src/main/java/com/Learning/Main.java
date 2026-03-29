package com.Learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // ------------------ Create Laptop Objects ------------------
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

        // ------------------ Create Programmer Object ------------------
        Programmer p1 = new Programmer();
        p1.setPid(101);
        p1.setPname("ABC");
        p1.setTech("Java");

        // ================= Relationship Setup =================

        // One Programmer -> Many Laptops
        p1.setLaptops(Arrays.asList(l1, l2));

        // Many Laptops -> One Programmer (owning side)
        l1.setProgrammer(p1);
        l2.setProgrammer(p1);

        // ------------------ Configure Hibernate ------------------
        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Programmer.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        // ------------------ Begin Transaction ------------------
        Transaction transaction = session.beginTransaction();

        // Save data
        session.persist(l1);
        session.persist(l2);
        session.persist(p1);

        // ------------------ Commit ------------------
        transaction.commit();

        // ------------------ Fetch Data ------------------
        Programmer p2 = session.get(Programmer.class, 101);

        // Will print programmer with laptops
        System.out.println(p2);

        // ------------------ Close ------------------
        session.close();
        sf.close();
    }
}
