package com.university.dao.impl;

import com.university.dao.StudentDAO;
import com.university.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO Implementation
 * Handles database operations for Student entity using JdbcTemplate
 * Schema: students (id, name, email, enrollment_date, department_id)
 * MVC Flow: Controller -> Service -> DAO -> Database
 */
@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Custom RowMapper to map ResultSet to Student object
     */
    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            java.sql.Date sqlDate = rs.getDate("enrollment_date");
            student.setEnrollmentDate(sqlDate != null ? sqlDate.toLocalDate() : null);
            student.setDepartmentId(rs.getInt("department_id"));
            try {
                student.setDepartmentName(rs.getString("dept_name"));
            } catch (SQLException e) {
                // Column might not exist if query didn't join
            }
            return student;
        }
    }

    /**
     * Create a new student in the database
     */
    @Override
    public boolean create(Student student) {
        String sql = "INSERT INTO students (name, email, enrollment_date, department_id) VALUES (?, ?, ?, ?)";
        try {
            int rows = jdbcTemplate.update(sql,
                student.getName(),
                student.getEmail(),
                java.sql.Date.valueOf(student.getEnrollmentDate()),
                student.getDepartmentId());
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieve all students from the database
     */
    @Override
    public List<Student> getAll() {
        String sql = "SELECT s.*, d.dept_name FROM students s LEFT JOIN departments d ON s.department_id = d.id ORDER BY s.id";
        try {
            return jdbcTemplate.query(sql, new StudentRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Retrieve a single student by ID
     */
    @Override
    public Student getById(int id) {
        String sql = "SELECT s.*, d.dept_name FROM students s LEFT JOIN departments d ON s.department_id = d.id WHERE s.id = ?";
        try {
            List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper(), id);
            return students.isEmpty() ? null : students.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Update an existing student in the database
     */
    @Override
    public boolean update(Student student) {
        String sql = "UPDATE students SET name = ?, email = ?, enrollment_date = ?, department_id = ? WHERE id = ?";
        try {
            int rows = jdbcTemplate.update(sql,
                student.getName(),
                student.getEmail(),
                java.sql.Date.valueOf(student.getEnrollmentDate()),
                student.getDepartmentId(),
                student.getId());
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete a student from the database
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try {
            int rows = jdbcTemplate.update(sql, id);
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

