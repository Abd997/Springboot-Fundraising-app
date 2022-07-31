package com.example.fundraisingapp.service;

import com.example.fundraisingapp.model.Projects;
import com.example.fundraisingapp.repository.ProjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectsService {
    
    @Autowired
    private ProjectsRepo projectsRepo;
    
    public List<Projects> getAllProjects() {
        ArrayList<Projects> projects = new ArrayList<>();
        projectsRepo.findAll().forEach(project -> projects.add(project));
        return projects;
    }
    
    public void addFunds(int funds, int id) {
        int oldFunds = projectsRepo.getFundsGiven(id);
        projectsRepo.updateFunds(oldFunds + funds, id);
    }
}