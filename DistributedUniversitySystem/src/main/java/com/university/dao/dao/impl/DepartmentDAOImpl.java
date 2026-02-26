package com.university.dao.impl;

import com.university.dao.DepartmentDAO;
import com.university.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DepartmentDAO Implementation
 * Handles database operations for Department entity using JdbcTemplate
 * Schema: departments (id, dept_name, office_location)
 */
@Repository("departmentDAO")
public class DepartmentDAOImpl implements DepartmentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Custom RowMapper to map ResultSet to Department object
     */
    private static class DepartmentRowMapper implements RowMapper<Department> {
        @Override
        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
            Department department = new Department();
            department.setId(rs.getInt("id"));
            department.setDeptName(rs.getString("dept_name"));
            department.setOfficeLocation(rs.getString("office_location"));
            return department;
        }
    }

    /**
     * Create a new department in the database
     */
    @Override
    public boolean create(Department department) {
        String sql = "INSERT INTO departments (dept_name, office_location) VALUES (?, ?)";
        try {
            int rows = jdbcTemplate.update(sql, department.getDeptName(), department.getOfficeLocation());
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieve all departments from the database
     */
    @Override
    public List<Department> getAll() {
        String sql = "SELECT * FROM departments ORDER BY id";
        try {
            return jdbcTemplate.query(sql, new DepartmentRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Retrieve a single department by ID
     */
    @Override
    public Department getById(int id) {
        String sql = "SELECT * FROM departments WHERE id = ?";
        try {
            List<Department> departments = jdbcTemplate.query(sql, new DepartmentRowMapper(), id);
            return departments.isEmpty() ? null : departments.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Update an existing department in the database
     */
    @Override
    public boolean update(Department department) {
        String sql = "UPDATE departments SET dept_name = ?, office_location = ? WHERE id = ?";
        try {
            int rows = jdbcTemplate.update(sql, department.getDeptName(), department.getOfficeLocation(), department.getId());
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete a department from the database
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM departments WHERE id = ?";
        try {
            int rows = jdbcTemplate.update(sql, id);
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

