package com.university.service;

import com.university.model.Department;
import java.util.List;

/**
 * DepartmentService Interface
 * Defines business logic operations for Department entity
 */
public interface DepartmentService {
    /**
     * Add a new department with validation
     * @param department Department to be added
     * @return true if successful, false otherwise
     */
    boolean addDepartment(Department department);

    /**
     * Get all departments
     * @return List of all departments
     */
    List<Department> getAllDepartments();

    /**
     * Get a department by ID
     * @param id Department ID
     * @return Department object if found, null otherwise
     */
    Department getDepartmentById(int id);

    /**
     * Update a department with validation
     * @param department Department with updated values
     * @return true if successful, false otherwise
     */
    boolean updateDepartment(Department department);

    /**
     * Delete a department
     * @param id Department ID
     * @return true if successful, false otherwise
     */
    boolean deleteDepartment(int id);
}

