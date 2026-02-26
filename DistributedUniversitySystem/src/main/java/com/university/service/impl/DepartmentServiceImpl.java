package com.university.service.impl;

import com.university.dao.DepartmentDAO;
import com.university.model.Department;
import com.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * DepartmentService Implementation
 * Handles business logic for Department operations
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    /**
     * Add a new department with validation
     */
    @Override
    public boolean addDepartment(Department department) {
        if (department == null || department.getDeptName() == null || department.getDeptName().trim().isEmpty()) {
            System.out.println("Error: Department name cannot be empty");
            return false;
        }
        if (department.getOfficeLocation() == null || department.getOfficeLocation().trim().isEmpty()) {
            System.out.println("Error: Office location cannot be empty");
            return false;
        }
        department.setDeptName(department.getDeptName().trim());
        department.setOfficeLocation(department.getOfficeLocation().trim());
        return departmentDAO.create(department);
    }

    /**
     * Retrieve all departments
     */
    @Override
    public List<Department> getAllDepartments() {
        return departmentDAO.getAll();
    }

    /**
     * Retrieve a department by ID
     */
    @Override
    public Department getDepartmentById(int id) {
        if (id <= 0) {
            System.out.println("Error: Invalid department ID");
            return null;
        }
        return departmentDAO.getById(id);
    }

    /**
     * Update a department with validation
     */
    @Override
    public boolean updateDepartment(Department department) {
        if (department == null || department.getId() <= 0) {
            System.out.println("Error: Invalid department ID");
            return false;
        }
        if (department.getDeptName() == null || department.getDeptName().trim().isEmpty()) {
            System.out.println("Error: Department name cannot be empty");
            return false;
        }
        if (department.getOfficeLocation() == null || department.getOfficeLocation().trim().isEmpty()) {
            System.out.println("Error: Office location cannot be empty");
            return false;
        }
        department.setDeptName(department.getDeptName().trim());
        department.setOfficeLocation(department.getOfficeLocation().trim());
        return departmentDAO.update(department);
    }

    /**
     * Delete a department
     */
    @Override
    public boolean deleteDepartment(int id) {
        if (id <= 0) {
            System.out.println("Error: Invalid department ID");
            return false;
        }
        return departmentDAO.delete(id);
    }
}

