package com.university.model;

/**
 * Lecturer Model Class
 * Represents a lecturer/faculty entity in the university system
 * Schema: id (PK), name, email (Unique), specialization, department_id (FK)
 */
public class Lecturer {
    private int id;
    private String name;
    private String email;
    private String specialization;
    private int departmentId;
    private String departmentName;

    // Constructors
    public Lecturer() {
    }

    public Lecturer(String name, String email, String specialization, int departmentId) {
        this.name = name;
        this.email = email;
        this.specialization = specialization;
        this.departmentId = departmentId;
    }

    public Lecturer(int id, String name, String email, String specialization, int departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.specialization = specialization;
        this.departmentId = departmentId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", specialization='" + specialization + '\'' +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
