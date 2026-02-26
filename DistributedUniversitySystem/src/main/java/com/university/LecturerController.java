package com.university.controller;

import com.university.model.Lecturer;
import com.university.service.LecturerService;
import com.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * LecturerController
 * Handles HTTP requests for Lecturer management
 * Registration Workflow: Department (1st) -> Lecturer (2nd) -> Course (3rd)
 */
@Controller
@RequestMapping("/lecturers")
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * Display list of all lecturers
     * GET /lecturers/list
     */
    @GetMapping("/list")
    public String listLecturers(Model model) {
        model.addAttribute("lecturers", lecturerService.getAllLecturers());
        return "lecturers/list";
    }

    /**
     * Display lecturer creation form with department dropdown
     * GET /lecturers/form
     */
    @GetMapping("/form")
    public String showLecturerForm(Model model) {
        model.addAttribute("lecturer", new Lecturer());
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("isEdit", false);
        return "lecturers/form";
    }

    /**
     * Handle lecturer creation/update
     * POST /lecturers/save
     */
    @PostMapping("/save")
    public String saveLecturer(Lecturer lecturer) {
        if (lecturer.getId() > 0) {
            lecturerService.updateLecturer(lecturer);
        } else {
            lecturerService.addLecturer(lecturer);
        }
        return "redirect:/lecturers/list";
    }

    /**
     * Display lecturer edit form with department dropdown
     * GET /lecturers/edit
     */
    @GetMapping("/edit")
    public String editLecturer(@RequestParam("id") int id, Model model) {
        Lecturer lecturer = lecturerService.getLecturerById(id);
        if (lecturer != null) {
            model.addAttribute("lecturer", lecturer);
            model.addAttribute("departments", departmentService.getAllDepartments());
            model.addAttribute("isEdit", true);
            return "lecturers/form";
        }
        return "redirect:/lecturers/list";
    }

    /**
     * Delete a lecturer
     * GET /lecturers/delete
     */
    @GetMapping("/delete")
    public String deleteLecturer(@RequestParam("id") int id) {
        lecturerService.deleteLecturer(id);
        return "redirect:/lecturers/list";
    }

    /**
     * Redirect to lecturer list
     * GET /lecturers
     */
    @GetMapping
    public String redirectToList() {
        return "redirect:/lecturers/list";
    }
}

