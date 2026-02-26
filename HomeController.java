package com.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController
 * Handles the home/index page and root context paths
 */
@Controller
public class HomeController {

    /**
     * Display home page
     * Handles both "/" and empty path to avoid ambiguous mapping errors
     * GET / or ""
     */
    @GetMapping({"/", ""})
    public String home() {
        return "home";
    }


    /**
     * Display dashboard
     * GET /dashboard
     */
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}

