package com.Learning;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Marks this class as a Hibernate Entity
// This class will be mapped to a database table
@Entity
public class Student {

    // Marks this field as Primary Key
    // Each student will be uniquely identified using rollNo
    @Id
    private int rollNo;

    // These fields will be mapped to table columns automatically
    private String sName;
    private int sAge;

    // Getter for age
    public int getsAge() {
        return sAge;
    }

    // Setter for age
    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    // Getter for name
    public String getsName() {
        return sName;
    }

    // Setter for name
    public void setsName(String sName) {
        this.sName = sName;
    }

    // Getter for roll number (Primary Key)
    public int getRollNo() {
        return rollNo;
    }

    // Setter for roll number
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    // toString() method for printing object data
    // Useful for debugging and logging
    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                '}';
    }
}
