package com.university.service;

import com.university.model.Lecturer;
import java.util.List;

/**
 * LecturerService Interface
 * Defines business logic operations for Lecturer entity
 */
public interface LecturerService {
    /**
     * Add a new lecturer with validation
     * @param lecturer Lecturer to be added
     * @return true if successful, false otherwise
     */
    boolean addLecturer(Lecturer lecturer);

    /**
     * Get all lecturers
     * @return List of all lecturers
     */
    List<Lecturer> getAllLecturers();

    /**
     * Get a lecturer by ID
     * @param id Lecturer ID
     * @return Lecturer object if found, null otherwise
     */
    Lecturer getLecturerById(int id);

    /**
     * Update a lecturer with validation
     * @param lecturer Lecturer with updated values
     * @return true if successful, false otherwise
     */
    boolean updateLecturer(Lecturer lecturer);

    /**
     * Delete a lecturer
     * @param id Lecturer ID
     * @return true if successful, false otherwise
     */
    boolean deleteLecturer(int id);
}

