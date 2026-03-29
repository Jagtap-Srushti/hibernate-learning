package com.Learning;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity  // Marks this class as a Hibernate entity, mapped to a database table
public class Programmer {

    @Id  // Marks pid as the primary key of the table
    private int pid;

    private String pname; // Name of the programmer
    private String tech;  // Technology the programmer works with

    private Laptop laptop; // Embedded or associated Laptop object (composition)

    // ================= Getter & Setter for Laptop =================
    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    // ================= Getter & Setter for PID =================
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    // ================= Getter & Setter for TECH =================
    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    // ================= Getter & Setter for PNAME =================
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    // ================= toString Method =================
    // Used to print Programmer object in readable format
    @Override
    public String toString() {
        return "Programmer{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
