package com.Learning;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity // Marks this class as a Hibernate entity
public class Programmer {

    @Id // Primary key
    private int pid;

    private String pname; // Programmer name
    private String tech;  // Technology field

    // ================= Many-to-Many Mapping =================
    // A programmer can have many laptops and a laptop can belong to many programmers
    @ManyToMany
    private List<Laptop> laptops;

    // ================= Getter & Setter for Laptops =================
    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
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
    // Prints Programmer object including the list of laptops
    @Override
    public String toString() {
        return "Programmer{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}
