package com.university.dao;

import com.university.model.Student;
import java.util.List;

/**
 * StudentDAO Interface
 * Defines CRUD operations for Student entity
 */
public interface StudentDAO {
    /**
     * Create a new student record
     * @param student Student object to be created
     * @return true if successful, false otherwise
     */
    boolean create(Student student);

    /**
     * Retrieve all students
     * @return List of all students
     */
    List<Student> getAll();

    /**
     * Retrieve a student by ID
     * @param id Student ID
     * @return Student object if found, null otherwise
     */
    Student getById(int id);

    /**
     * Update an existing student record
     * @param student Student object with updated values
     * @return true if successful, false otherwise
     */
    boolean update(Student student);

    /**
     * Delete a student by ID
     * @param id Student ID
     * @return true if successful, false otherwise
     */
    boolean delete(int id);
}

