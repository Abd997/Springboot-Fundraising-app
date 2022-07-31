package com.example.fundraisingapp.controller;

import com.example.fundraisingapp.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    
    @Autowired
    ProjectsService projectsService;
    
    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("projects", projectsService.getAllProjects());
        return "homePage";
    }
}