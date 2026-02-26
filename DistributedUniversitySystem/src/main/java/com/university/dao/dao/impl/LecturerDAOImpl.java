package com.university.dao.impl;

import com.university.dao.LecturerDAO;
import com.university.model.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * LecturerDAO Implementation
 * Handles database operations for Lecturer entity using JdbcTemplate
 * Schema: lecturers (id, name, email, specialization, department_id)
 */
@Repository("lecturerDAO")
public class LecturerDAOImpl implements LecturerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Custom RowMapper to map ResultSet to Lecturer object
     */
    private static class LecturerRowMapper implements RowMapper<Lecturer> {
        @Override
        public Lecturer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Lecturer lecturer = new Lecturer();
            lecturer.setId(rs.getInt("id"));
            lecturer.setName(rs.getString("name"));
            lecturer.setEmail(rs.getString("email"));
            lecturer.setSpecialization(rs.getString("specialization"));
            lecturer.setDepartmentId(rs.getInt("department_id"));
            try {
                lecturer.setDepartmentName(rs.getString("dept_name"));
            } catch (SQLException e) {
                // Column might not exist
            }
            return lecturer;
        }
    }

    /**
     * Create a new lecturer in the database
     */
    @Override
    public boolean create(Lecturer lecturer) {
        String sql = "INSERT INTO lecturers (name, email, specialization, department_id) VALUES (?, ?, ?, ?)";
        try {
            int rows = jdbcTemplate.update(sql,
                lecturer.getName(),
                lecturer.getEmail(),
                lecturer.getSpecialization(),
                lecturer.getDepartmentId());
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieve all lecturers from the database
     */
    @Override
    public List<Lecturer> getAll() {
        String sql = "SELECT l.*, d.dept_name FROM lecturers l LEFT JOIN departments d ON l.department_id = d.id ORDER BY l.id";
        try {
            return jdbcTemplate.query(sql, new LecturerRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Retrieve a single lecturer by ID
     */
    @Override
    public Lecturer getById(int id) {
        String sql = "SELECT l.*, d.dept_name FROM lecturers l LEFT JOIN departments d ON l.department_id = d.id WHERE l.id = ?";
        try {
            List<Lecturer> lecturers = jdbcTemplate.query(sql, new LecturerRowMapper(), id);
            return lecturers.isEmpty() ? null : lecturers.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Update an existing lecturer in the database
     */
    @Override
    public boolean update(Lecturer lecturer) {
        String sql = "UPDATE lecturers SET name = ?, email = ?, specialization = ?, department_id = ? WHERE id = ?";
        try {
            int rows = jdbcTemplate.update(sql,
                lecturer.getName(),
                lecturer.getEmail(),
                lecturer.getSpecialization(),
                lecturer.getDepartmentId(),
                lecturer.getId());
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete a lecturer from the database
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM lecturers WHERE id = ?";
        try {
            int rows = jdbcTemplate.update(sql, id);
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

