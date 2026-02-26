package com.university.dao;

import com.university.model.Lecturer;
import java.util.List;

/**
 * LecturerDAO Interface
 * Defines CRUD operations for Lecturer entity
 */
public interface LecturerDAO {
    /**
     * Create a new lecturer record
     * @param lecturer Lecturer object to be created
     * @return true if successful, false otherwise
     */
    boolean create(Lecturer lecturer);

    /**
     * Retrieve all lecturers
     * @return List of all lecturers
     */
    List<Lecturer> getAll();

    /**
     * Retrieve a lecturer by ID
     * @param id Lecturer ID
     * @return Lecturer object if found, null otherwise
     */
    Lecturer getById(int id);

    /**
     * Update an existing lecturer record
     * @param lecturer Lecturer object with updated values
     * @return true if successful, false otherwise
     */
    boolean update(Lecturer lecturer);

    /**
     * Delete a lecturer by ID
     * @param id Lecturer ID
     * @return true if successful, false otherwise
     */
    boolean delete(int id);
}

