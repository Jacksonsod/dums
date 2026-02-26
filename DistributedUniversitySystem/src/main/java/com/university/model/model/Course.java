package com.university.model;

/**
 * Course Model Class
 * Represents a course entity in the university system
 * Schema: id (PK), course_code (Unique), title, credits, department_id (FK), lecturer_id (FK)
 */
public class Course {
    private int id;
    private String courseCode;
    private String title;
    private int credits;
    private int departmentId;
    private int lecturerId;
    private String departmentName;
    private String lecturerName;

    // Constructors
    public Course() {
    }

    public Course(String courseCode, String title, int credits, int departmentId, int lecturerId) {
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.departmentId = departmentId;
        this.lecturerId = lecturerId;
    }

    public Course(int id, String courseCode, String title, int credits, int departmentId, int lecturerId) {
        this.id = id;
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.departmentId = departmentId;
        this.lecturerId = lecturerId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                ", departmentId=" + departmentId +
                ", lecturerId=" + lecturerId +
                '}';
    }
}
