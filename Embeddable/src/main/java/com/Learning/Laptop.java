package com.;

import jakarta.persistence.Embeddable;

@Embeddable  // Marks this class as an embeddable object in Hibernate
// Its fields will be stored as part of the parent entity's table
public class Laptop {

    private String brand; // Brand of the laptop (e.g., Dell, HP)
    private String model; // Model of the laptop (e.g., Inspiron, Pavilion)
    private int ram;      // RAM size in GB

    // ================= Setters =================
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    // ================= Getters =================
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    // ================= toString Method =================
    // Used to print the Laptop object in a readable format
    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
