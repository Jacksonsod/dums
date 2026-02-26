package com.university.service;

import com.university.model.Student;
import java.util.List;

/**
 * StudentService Interface
 * Defines business logic operations for Student entity
 * Service layer handles validation and business rules
 */
public interface StudentService {
    /**
     * Add a new student with validation
     * @param student Student to be added
     * @return true if successful, false otherwise
     */
    boolean addStudent(Student student);

    /**
     * Get all students
     * @return List of all students
     */
    List<Student> getAllStudents();

    /**
     * Get a student by ID
     * @param id Student ID
     * @return Student object if found, null otherwise
     */
    Student getStudentById(int id);

    /**
     * Update a student with validation
     * @param student Student with updated values
     * @return true if successful, false otherwise
     */
    boolean updateStudent(Student student);

    /**
     * Delete a student
     * @param id Student ID
     * @return true if successful, false otherwise
     */
    boolean deleteStudent(int id);
}

