package com.university.service.impl;

import com.university.dao.StudentDAO;
import com.university.model.Student;
import com.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;

/**
 * StudentService Implementation
 * Handles business logic for Student operations
 * MVC Flow: Controller -> Service -> DAO
 * Provides validation and business rule enforcement
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    /**
     * Add a new student with validation
     * Validates that name, email, departmentId, and enrollmentDate are valid
     */
    @Override
    public boolean addStudent(Student student) {
        // Validation
        if (student == null || student.getName() == null || student.getName().trim().isEmpty()) {
            System.out.println("Error: Student name cannot be empty");
            return false;
        }
        if (student.getEmail() == null || student.getEmail().trim().isEmpty()) {
            System.out.println("Error: Student email cannot be empty");
            return false;
        }
        if (student.getDepartmentId() <= 0) {
            System.out.println("Error: Student department ID must be valid");
            return false;
        }
        if (student.getEnrollmentDate() == null) {
            System.out.println("Error: Student enrollment date cannot be empty");
            return false;
        }
        // Trim whitespace
        student.setName(student.getName().trim());
        student.setEmail(student.getEmail().trim());

        return studentDAO.create(student);
    }

    /**
     * Retrieve all students
     */
    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAll();
    }

    /**
     * Retrieve a student by ID
     */
    @Override
    public Student getStudentById(int id) {
        if (id <= 0) {
            System.out.println("Error: Invalid student ID");
            return null;
        }
        return studentDAO.getById(id);
    }

    /**
     * Update a student with validation
     */
    @Override
    public boolean updateStudent(Student student) {
        if (student == null || student.getId() <= 0) {
            System.out.println("Error: Invalid student ID");
            return false;
        }
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            System.out.println("Error: Student name cannot be empty");
            return false;
        }
        if (student.getEmail() == null || student.getEmail().trim().isEmpty()) {
            System.out.println("Error: Student email cannot be empty");
            return false;
        }
        if (student.getDepartmentId() <= 0) {
            System.out.println("Error: Student department ID must be valid");
            return false;
        }
        if (student.getEnrollmentDate() == null) {
            System.out.println("Error: Student enrollment date cannot be empty");
            return false;
        }
        // Trim whitespace
        student.setName(student.getName().trim());
        student.setEmail(student.getEmail().trim());

        return studentDAO.update(student);
    }

    /**
     * Delete a student
     */
    @Override
    public boolean deleteStudent(int id) {
        if (id <= 0) {
            System.out.println("Error: Invalid student ID");
            return false;
        }
        return studentDAO.delete(id);
    }
}

