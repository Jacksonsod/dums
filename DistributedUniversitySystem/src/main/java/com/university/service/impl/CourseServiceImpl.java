package com.university.service.impl;

import com.university.dao.CourseDAO;
import com.university.model.Course;
import com.university.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * CourseService Implementation
 * Handles business logic for Course operations
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;

    /**
     * Add a new course with validation
     */
    @Override
    public boolean addCourse(Course course) {
        if (course == null || course.getTitle() == null || course.getTitle().trim().isEmpty()) {
            System.out.println("Error: Course title cannot be empty");
            return false;
        }
        if (course.getCredits() <= 0) {
            System.out.println("Error: Course credits must be greater than 0");
            return false;
        }
        if (course.getLecturerId() <= 0) {
            System.out.println("Error: Invalid lecturer ID");
            return false;
        }
        course.setTitle(course.getTitle().trim());
        return courseDAO.create(course);
    }

    /**
     * Retrieve all courses
     */
    @Override
    public List<Course> getAllCourses() {
        return courseDAO.getAll();
    }

    /**
     * Retrieve a course by ID
     */
    @Override
    public Course getCourseById(int id) {
        if (id <= 0) {
            System.out.println("Error: Invalid course ID");
            return null;
        }
        return courseDAO.getById(id);
    }

    /**
     * Update a course with validation
     */
    @Override
    public boolean updateCourse(Course course) {
        if (course == null || course.getId() <= 0) {
            System.out.println("Error: Invalid course ID");
            return false;
        }
        if (course.getTitle() == null || course.getTitle().trim().isEmpty()) {
            System.out.println("Error: Course title cannot be empty");
            return false;
        }
        if (course.getCredits() <= 0) {
            System.out.println("Error: Course credits must be greater than 0");
            return false;
        }
        if (course.getLecturerId() <= 0) {
            System.out.println("Error: Invalid lecturer ID");
            return false;
        }
        course.setTitle(course.getTitle().trim());
        return courseDAO.update(course);
    }

    /**
     * Delete a course
     */
    @Override
    public boolean deleteCourse(int id) {
        if (id <= 0) {
            System.out.println("Error: Invalid course ID");
            return false;
        }
        return courseDAO.delete(id);
    }
}

