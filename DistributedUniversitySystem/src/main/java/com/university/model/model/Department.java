package com.university.model;

/**
 * Department Model Class
 * Represents a department entity in the university system
 * Schema: id (PK), dept_name (Unique), office_location
 */
public class Department {
    private int id;
    private String deptName;
    private String officeLocation;

    // Constructors
    public Department() {
    }

    public Department(String deptName, String officeLocation) {
        this.deptName = deptName;
        this.officeLocation = officeLocation;
    }

    public Department(int id, String deptName, String officeLocation) {
        this.id = id;
        this.deptName = deptName;
        this.officeLocation = officeLocation;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", officeLocation='" + officeLocation + '\'' +
                '}';
    }
}

