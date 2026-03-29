package com.telusko;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // Marks this class as a Hibernate entity, mapped to a database table
public class Laptop {

    @Id // Primary key of the Laptop table
    private int lid;

    private String brand; // Brand of the laptop (e.g., Dell, Asus)
    private String model; // Model of the laptop (e.g., Inspiron, ROG)
    private int ram;      // RAM size in GB

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
    // Prints Laptop object in a readable format
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
