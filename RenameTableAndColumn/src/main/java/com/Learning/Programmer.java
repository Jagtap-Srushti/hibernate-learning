package com.Learning;

import jakarta.persistence.*;

@Entity
@Table(name = "programmer_table")  // Specify custom table name
public class Programmer {

    @Id
    private int pid;  // Primary key

    @Column(name = "programmer_name")  // Maps pname to a custom column name
    private String pname;

    @Transient  // This field will NOT be stored in the database
    private String tech;

    // ================= Getter & Setter for PID =================
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    // ================= Getter & Setter for PNAME =================
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    // ================= Getter & Setter for TECH =================
    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    // ================= toString Method =================
    // Prints Programmer object in a readable format
    @Override
    public String toString() {
        return "Programmer{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
