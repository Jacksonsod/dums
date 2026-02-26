package com.university.controller;

import com.university.model.Department;
import com.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * DepartmentController
 * Handles HTTP requests for Department management
 */
@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * Display list of all departments
     * GET /departments/list
     */
    @GetMapping("/list")
    public String listDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "departments/list";
    }

    /**
     * Display department creation form
     * GET /departments/form
     */
    @GetMapping("/form")
    public String showDepartmentForm(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("isEdit", false);
        return "departments/form";
    }

    /**
     * Handle department creation/update
     * POST /departments/save
     */
    @PostMapping("/save")
    public String saveDepartment(Department department) {
        if (department.getId() > 0) {
            departmentService.updateDepartment(department);
        } else {
            departmentService.addDepartment(department);
        }
        return "redirect:/departments/list";
    }

    /**
     * Display department edit form
     * GET /departments/edit
     */
    @GetMapping("/edit")
    public String editDepartment(@RequestParam("id") int id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        if (department != null) {
            model.addAttribute("department", department);
            model.addAttribute("isEdit", true);
            return "departments/form";
        }
        return "redirect:/departments/list";
    }

    /**
     * Delete a department
     * GET /departments/delete
     */
    @GetMapping("/delete")
    public String deleteDepartment(@RequestParam("id") int id) {
        departmentService.deleteDepartment(id);
        return "redirect:/departments/list";
    }

    /**
     * Redirect to department list
     * GET /departments
     */
    @GetMapping
    public String redirectToList() {
        return "redirect:/departments/list";
    }
}

