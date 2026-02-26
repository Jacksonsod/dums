package com.university.model;

import java.time.LocalDate;

/**
 * Student Model Class
 * Represents a student entity in the university system
 * Schema: id (PK), name, email (Unique), enrollment_date, department_id (FK)
 */
public class Student {
    private int id;
    private String name;
    private String email;
    private LocalDate enrollmentDate;
    private int departmentId;
    private String departmentName;

    // Constructors
    public Student() {
    }

    public Student(String name, String email, LocalDate enrollmentDate, int departmentId) {
        this.name = name;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.departmentId = departmentId;
    }

    public Student(int id, String name, String email, LocalDate enrollmentDate, int departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
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

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
