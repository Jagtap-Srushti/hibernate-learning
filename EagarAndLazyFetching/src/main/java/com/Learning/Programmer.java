package com.Learning;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

// Marks this class as an Entity (mapped to DB table)
@Entity
public class Programmer {

    // Primary Key
    @Id
    private int pid;

    // Programmer name
    private String pname;

    // Technology (Java, Python, etc.)
    private String tech;

    // One Programmer → Many Laptops
    // EAGER → loads laptops immediately with programmer
    @OneToMany(fetch = FetchType.EAGER)
    private List<Laptop> laptops;

    // Getter for laptops
    public List<Laptop> getLaptops() {
        return laptops;
    }

    // Setter for laptops
    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    // Getter for pid
    public int getPid() {
        return pid;
    }

    // Setter for pid
    public void setPid(int pid) {
        this.pid = pid;
    }

    // Getter for tech
    public String getTech() {
        return tech;
    }

    // Setter for tech
    public void setTech(String tech) {
        this.tech = tech;
    }

    // Getter for pname
    public String getPname() {
        return pname;
    }

    // Setter for pname
    public void setPname(String pname) {
        this.pname = pname;
    }

    // toString() for debugging
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
