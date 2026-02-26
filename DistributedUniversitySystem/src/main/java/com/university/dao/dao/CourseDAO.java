package com.university.dao;

import com.university.model.Course;
import java.util.List;

/**
 * CourseDAO Interface
 * Defines CRUD operations for Course entity
 */
public interface CourseDAO {
    /**
     * Create a new course record
     * @param course Course object to be created
     * @return true if successful, false otherwise
     */
    boolean create(Course course);

    /**
     * Retrieve all courses
     * @return List of all courses
     */
    List<Course> getAll();

    /**
     * Retrieve a course by ID
     * @param id Course ID
     * @return Course object if found, null otherwise
     */
    Course getById(int id);

    /**
     * Update an existing course record
     * @param course Course object with updated values
     * @return true if successful, false otherwise
     */
    boolean update(Course course);

    /**
     * Delete a course by ID
     * @param id Course ID
     * @return true if successful, false otherwise
     */
    boolean delete(int id);
}

