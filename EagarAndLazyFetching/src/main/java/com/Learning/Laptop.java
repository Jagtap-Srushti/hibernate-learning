package com.Learning;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Marks this class as an Entity (mapped to a DB table)
// Table name by default = "Laptop"
@Entity
public class Laptop {

    // Primary Key of the table
    // Each laptop will be uniquely identified by lid
    @Id
    private int lid;

    // These fields will be mapped to columns in DB
    private String brand;
    private String model;
    private int ram;

    // Getter for Primary Key
    public int getLid() {
        return lid;
    }

    // Setter for Primary Key
    public void setLid(int lid) {
        this.lid = lid;
    }

    // Setter for model
    public void setModel(String model) {
        this.model = model;
    }

    // Setter for RAM
    public void setRam(int ram) {
        this.ram = ram;
    }

    // Setter for brand
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter for brand
    public String getBrand() {
        return brand;
    }

    // Getter for RAM
    public int getRam() {
        return ram;
    }

    // Getter for model
    public String getModel() {
        return model;
    }

    // toString() method for printing object data
    // Useful for debugging and logs
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
