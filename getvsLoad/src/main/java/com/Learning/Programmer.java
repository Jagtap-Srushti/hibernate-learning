package com.Learning;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity // Marks this class as a Hibernate entity (mapped to a DB table)
public class Programmer {

    @Id // Primary key of the table
    private int pid;

    private String pname; // Name of the programmer
    private String tech;  // Technology the programmer works with

    // ================= One-to-Many Mapping =================
    // One Programmer can have multiple Laptops
    // FetchType.EAGER -> Laptops will be fetched immediately with Programmer
    @OneToMany(fetch = FetchType.EAGER)
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
    // Used to print Programmer details including associated laptops
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
