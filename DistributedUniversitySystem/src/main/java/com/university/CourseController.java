package com.university.controller;

import com.university.model.Course;
import com.university.service.CourseService;
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
 * CourseController
 * Handles HTTP requests for Course management
 * Registration Workflow: Department (1st) -> Lecturer & Student (2nd) -> Course (3rd)
 */
@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * Display list of all courses
     * GET /courses/list
     */
    @GetMapping("/list")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses/list";
    }

    /**
     * Display course creation form with department and lecturer dropdowns
     * GET /courses/form
     */
    @GetMapping("/form")
    public String showCourseForm(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("lecturers", lecturerService.getAllLecturers());
        model.addAttribute("isEdit", false);
        return "courses/form";
    }

    /**
     * Handle course creation/update
     * POST /courses/save
     */
    @PostMapping("/save")
    public String saveCourse(Course course) {
        if (course.getId() > 0) {
            courseService.updateCourse(course);
        } else {
            courseService.addCourse(course);
        }
        return "redirect:/courses/list";
    }

    /**
     * Display course edit form with department and lecturer dropdowns
     * GET /courses/edit
     */
    @GetMapping("/edit")
    public String editCourse(@RequestParam("id") int id, Model model) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            model.addAttribute("course", course);
            model.addAttribute("departments", departmentService.getAllDepartments());
            model.addAttribute("lecturers", lecturerService.getAllLecturers());
            model.addAttribute("isEdit", true);
            return "courses/form";
        }
        return "redirect:/courses/list";
    }

    /**
     * Delete a course
     * GET /courses/delete
     */
    @GetMapping("/delete")
    public String deleteCourse(@RequestParam("id") int id) {
        courseService.deleteCourse(id);
        return "redirect:/courses/list";
    }

    /**
     * Redirect to course list
     * GET /courses
     */
    @GetMapping
    public String redirectToList() {
        return "redirect:/courses/list";
    }
}

