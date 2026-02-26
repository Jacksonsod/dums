package com.university.service;

import com.university.model.Course;
import java.util.List;

/**
 * CourseService Interface
 * Defines business logic operations for Course entity
 */
public interface CourseService {
    /**
     * Add a new course with validation
     * @param course Course to be added
     * @return true if successful, false otherwise
     */
    boolean addCourse(Course course);

    /**
     * Get all courses
     * @return List of all courses
     */
    List<Course> getAllCourses();

    /**
     * Get a course by ID
     * @param id Course ID
     * @return Course object if found, null otherwise
     */
    Course getCourseById(int id);

    /**
     * Update a course with validation
     * @param course Course with updated values
     * @return true if successful, false otherwise
     */
    boolean updateCourse(Course course);

    /**
     * Delete a course
     * @param id Course ID
     * @return true if successful, false otherwise
     */
    boolean deleteCourse(int id);
}

