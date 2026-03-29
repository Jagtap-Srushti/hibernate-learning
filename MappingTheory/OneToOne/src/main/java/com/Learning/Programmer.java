package com.telusko;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity // Marks this class as a Hibernate entity
public class Programmer {

    @Id // Primary key of the table
    private int pid;

    private String pname; // Programmer's name
    private String tech;  // Technology the programmer works with

    // ================= One-to-One Mapping =================
    // Each programmer has one laptop
    @OneToOne
    private Laptop laptop;

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
    // Prints Programmer object in a readable format
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
