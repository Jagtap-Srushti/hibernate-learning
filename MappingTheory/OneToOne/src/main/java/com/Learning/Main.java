package com.Learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

        public class Main {
            public static void main(String[] args) {

                // ================= Create Laptop Object =================
                // Create a Laptop instance to be associated with Programmer
                Laptop l1 = new Laptop();
                l1.setLid(1);         // Set Laptop ID (primary key)
                l1.setBrand("Asus");  // Set brand name
                l1.setModel("Rog");   // Set model name
                l1.setRam(16);        // Set RAM size in GB

                // ================= Create Programmer Object =================
                // Create a Programmer instance and set fields
                Programmer p1 = new Programmer();
                p1.setPid(101);       // Set Programmer ID (primary key)
                p1.setPname("ABC"); // Set programmer name
                p1.setTech("Java");   // This field is transient (not saved in DB)
                p1.setLaptop(l1);     // Associate the Laptop object with Programmer

                // ================= Configure Hibernate =================
                // Create SessionFactory and register annotated classes
                SessionFactory sf = new Configuration()
                        .configure()                     // Reads hibernate.cfg.xml
                        .addAnnotatedClass(com.Learning.Programmer.class) // Register Programmer entity
                        .addAnnotatedClass(com.Learning.Laptop.class)     // Register Laptop entity
                        .buildSessionFactory();

                // ================= Open Hibernate Session =================
                Session session = sf.openSession();

        
                // ================= Begin Transaction =================
                Transaction transaction = session.beginTransaction();

                // ================= Persist Entities =================
                // Save Laptop first (because Programmer references it)
                session.persist(l1);
                // Save Programmer object to DB
                session.persist(p1);

                // ================= Commit Transaction =================
                transaction.commit();

                // ================= Fetch and Print Programmer =================
                // Retrieve Programmer by primary key
                Programmer p2 = session.get(Programmer.class, 101);
                System.out.println(p2); // Prints Programmer details with associated Laptop

                // ================= Close Session & SessionFactory =================
                session.close();
                sf.close();
            }
        }


