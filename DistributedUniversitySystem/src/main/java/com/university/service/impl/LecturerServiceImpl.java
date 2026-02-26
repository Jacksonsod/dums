package com.university.service.impl;

import com.university.dao.LecturerDAO;
import com.university.model.Lecturer;
import com.university.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * LecturerService Implementation
 * Handles business logic for Lecturer operations
 */
@Service("lecturerService")
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    private LecturerDAO lecturerDAO;

    /**
     * Add a new lecturer with validation
     */
    @Override
    public boolean addLecturer(Lecturer lecturer) {
        if (lecturer == null || lecturer.getName() == null || lecturer.getName().trim().isEmpty()) {
            System.out.println("Error: Lecturer name cannot be empty");
            return false;
        }
        if (lecturer.getSpecialization() == null || lecturer.getSpecialization().trim().isEmpty()) {
            System.out.println("Error: Lecturer specialization cannot be empty");
            return false;
        }
        lecturer.setName(lecturer.getName().trim());
        lecturer.setSpecialization(lecturer.getSpecialization().trim());
        return lecturerDAO.create(lecturer);
    }

    /**
     * Retrieve all lecturers
     */
    @Override
    public List<Lecturer> getAllLecturers() {
        return lecturerDAO.getAll();
    }

    /**
     * Retrieve a lecturer by ID
     */
    @Override
    public Lecturer getLecturerById(int id) {
        if (id <= 0) {
            System.out.println("Error: Invalid lecturer ID");
            return null;
        }
        return lecturerDAO.getById(id);
    }

    /**
     * Update a lecturer with validation
     */
    @Override
    public boolean updateLecturer(Lecturer lecturer) {
        if (lecturer == null || lecturer.getId() <= 0) {
            System.out.println("Error: Invalid lecturer ID");
            return false;
        }
        if (lecturer.getName() == null || lecturer.getName().trim().isEmpty()) {
            System.out.println("Error: Lecturer name cannot be empty");
            return false;
        }
        if (lecturer.getSpecialization() == null || lecturer.getSpecialization().trim().isEmpty()) {
            System.out.println("Error: Lecturer specialization cannot be empty");
            return false;
        }
        lecturer.setName(lecturer.getName().trim());
        lecturer.setSpecialization(lecturer.getSpecialization().trim());
        return lecturerDAO.update(lecturer);
    }

    /**
     * Delete a lecturer
     */
    @Override
    public boolean deleteLecturer(int id) {
        if (id <= 0) {
            System.out.println("Error: Invalid lecturer ID");
            return false;
        }
        return lecturerDAO.delete(id);
    }
}

