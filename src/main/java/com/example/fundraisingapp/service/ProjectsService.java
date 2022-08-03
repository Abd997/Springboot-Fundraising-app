package com.example.fundraisingapp.service;

import com.example.fundraisingapp.model.Projects;
import com.example.fundraisingapp.repository.ProjectsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectsService {
    
    @Autowired
    private ProjectsDao projectsDao;
    
    public List<Projects> getAllProjects() {
        ArrayList<Projects> projects = new ArrayList<>();
        projectsDao.findAll().forEach(project -> projects.add(project));
        return projects;
    }
    
    public void addFunds(int funds, int id) {
        int oldFunds = projectsDao.getFundsGiven(id);
        projectsDao.updateFunds(oldFunds + funds, id);
    }
}