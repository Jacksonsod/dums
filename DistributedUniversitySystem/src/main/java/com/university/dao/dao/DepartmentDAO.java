package com.university.dao;

import com.university.model.Department;
import java.util.List;

/**
 * DepartmentDAO Interface
 * Defines CRUD operations for Department entity
 */
public interface DepartmentDAO {
    /**
     * Create a new department record
     * @param department Department object to be created
     * @return true if successful, false otherwise
     */
    boolean create(Department department);

    /**
     * Retrieve all departments
     * @return List of all departments
     */
    List<Department> getAll();

    /**
     * Retrieve a department by ID
     * @param id Department ID
     * @return Department object if found, null otherwise
     */
    Department getById(int id);

    /**
     * Update an existing department record
     * @param department Department object with updated values
     * @return true if successful, false otherwise
     */
    boolean update(Department department);

    /**
     * Delete a department by ID
     * @param id Department ID
     * @return true if successful, false otherwise
     */
    boolean delete(int id);
}

