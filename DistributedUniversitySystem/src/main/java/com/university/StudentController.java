package com.university.controller;

import com.university.model.Student;
import com.university.service.StudentService;
import com.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * StudentController
 * Handles HTTP requests for Student management
 * MVC Flow: Request -> Controller -> Service -> DAO -> Database
 * Registration Workflow: Department (1st) -> Student (2nd) -> Course (3rd)
 */
@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * Display list of all students
     * GET /students/list
     */
    @GetMapping("/list")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students/list";
    }

    /**
     * Display student creation form with department dropdown
     * GET /students/form
     */
    @GetMapping("/form")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("isEdit", false);
        return "students/form";
    }

    /**
     * Handle student creation
     * POST /students/save
     */
    @PostMapping("/save")
    public String saveStudent(Student student) {
        if (student.getId() > 0) {
            // Update existing student
            studentService.updateStudent(student);
        } else {
            // Create new student
            studentService.addStudent(student);
        }
        return "redirect:/students/list";
    }

    /**
     * Display student edit form with department dropdown
     * GET /students/edit
     */
    @GetMapping("/edit")
    public String editStudent(@RequestParam("id") int id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
            model.addAttribute("departments", departmentService.getAllDepartments());
            model.addAttribute("isEdit", true);
            return "students/form";
        }
        return "redirect:/students/list";
    }

    /**
     * Delete a student
     * GET /students/delete
     */
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }

    /**
     * Redirect to student list
     * GET /students
     */
    @GetMapping
    public String redirectToList() {
        return "redirect:/students/list";
    }
}

