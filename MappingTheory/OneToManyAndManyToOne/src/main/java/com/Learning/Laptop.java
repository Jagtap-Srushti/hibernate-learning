package com.Learning;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity // Marks this class as a Hibernate entity
public class Laptop {

    @Id // Primary key of Laptop table
    private int lid;

    private String brand; // Laptop brand
    private String model; // Laptop model
    private int ram;      // RAM size

    // ================= Many-to-One Mapping =================
    // Many laptops can belong to one programmer
    @ManyToOne
    private Programmer programmer;

    // ================= Getter & Setter for Programmer =================
    public Programmer getProgrammer() {
        return programmer;
    }

    public void setProgrammer(Programmer programmer) {
        this.programmer = programmer;
    }

    // ================= Getter & Setter for LID =================
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    // ================= Getter & Setter for BRAND =================
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // ================= Getter & Setter for MODEL =================
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // ================= Getter & Setter for RAM =================
    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    // ================= toString Method =================
    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
