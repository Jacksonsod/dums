package com.university.dao.impl;

import com.university.dao.CourseDAO;
import com.university.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * CourseDAO Implementation
 * Handles database operations for Course entity using JdbcTemplate
 * Schema: courses (id, course_code, title, credits, department_id, lecturer_id)
 */
@Repository("courseDAO")
public class CourseDAOImpl implements CourseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Custom RowMapper to map ResultSet to Course object
     */
    private static class CourseRowMapper implements RowMapper<Course> {
        @Override
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            Course course = new Course();
            course.setId(rs.getInt("id"));
            course.setCourseCode(rs.getString("course_code"));
            course.setTitle(rs.getString("title"));
            course.setCredits(rs.getInt("credits"));
            course.setDepartmentId(rs.getInt("department_id"));
            course.setLecturerId(rs.getInt("lecturer_id"));
            try {
                course.setDepartmentName(rs.getString("dept_name"));
            } catch (SQLException e) {
                // Column might not exist
            }
            try {
                course.setLecturerName(rs.getString("lecturer_name"));
            } catch (SQLException e) {
                // Column might not exist
            }
            return course;
        }
    }

    /**
     * Create a new course in the database
     */
    @Override
    public boolean create(Course course) {
        String sql = "INSERT INTO courses (course_code, title, credits, department_id, lecturer_id) VALUES (?, ?, ?, ?, ?)";
        try {
            int rows = jdbcTemplate.update(sql,
                course.getCourseCode(),
                course.getTitle(),
                course.getCredits(),
                course.getDepartmentId(),
                course.getLecturerId());
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieve all courses from the database
     */
    @Override
    public List<Course> getAll() {
        String sql = "SELECT c.*, d.dept_name, l.name AS lecturer_name FROM courses c " +
                     "LEFT JOIN departments d ON c.department_id = d.id " +
                     "LEFT JOIN lecturers l ON c.lecturer_id = l.id " +
                     "ORDER BY c.id";
        try {
            return jdbcTemplate.query(sql, new CourseRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Retrieve a single course by ID
     */
    @Override
    public Course getById(int id) {
        String sql = "SELECT c.*, d.dept_name, l.name AS lecturer_name FROM courses c " +
                     "LEFT JOIN departments d ON c.department_id = d.id " +
                     "LEFT JOIN lecturers l ON c.lecturer_id = l.id " +
                     "WHERE c.id = ?";
        try {
            List<Course> courses = jdbcTemplate.query(sql, new CourseRowMapper(), id);
            return courses.isEmpty() ? null : courses.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Update an existing course in the database
     */
    @Override
    public boolean update(Course course) {
        String sql = "UPDATE courses SET course_code = ?, title = ?, credits = ?, department_id = ?, lecturer_id = ? WHERE id = ?";
        try {
            int rows = jdbcTemplate.update(sql,
                course.getCourseCode(),
                course.getTitle(),
                course.getCredits(),
                course.getDepartmentId(),
                course.getLecturerId(),
                course.getId());
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete a course from the database
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM courses WHERE id = ?";
        try {
            int rows = jdbcTemplate.update(sql, id);
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

