package com.example.fundraisingapp;

import com.example.fundraisingapp.model.FundRaisers;
import com.example.fundraisingapp.model.Projects;
import com.example.fundraisingapp.repository.FundRaisersRepo;
import com.example.fundraisingapp.repository.ProjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class insertStartData {
    
    @Autowired
    private FundRaisersRepo fundRaisersRepo;
    
    @Autowired
    private ProjectsRepo projectsRepo;
    
    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        fundRaisersRepo.save(new FundRaisers(1, "user1", "password", 1000));
        fundRaisersRepo.save(new FundRaisers(2, "user2", "password", 100));
        for (int i = 1; i < 10; i++) {
            projectsRepo.save(new Projects(i, "project " + i, 100 * i, 0));
        }
    }
}