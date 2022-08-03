package com.example.fundraisingapp;

import com.example.fundraisingapp.model.FundContributor;
import com.example.fundraisingapp.model.FundSeeker;
import com.example.fundraisingapp.model.PlatformOwner;
import com.example.fundraisingapp.model.Projects;
import com.example.fundraisingapp.repository.FundContributorDao;
import com.example.fundraisingapp.repository.FundSeekerDao;
import com.example.fundraisingapp.repository.PlatformOwnerDao;
import com.example.fundraisingapp.repository.ProjectsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class insertStartData {
    
    @Autowired
    private FundContributorDao fundContributorDao;
    
    @Autowired
    private FundSeekerDao fundSeekerDao;
    
    @Autowired
    private ProjectsDao projectsDao;
    
    @Autowired
    private PlatformOwnerDao platformOwnerDao;
    
    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        
        fundSeekerDao.save(new FundSeeker(
                1,
                "seeker",
                "seeker@gmail.com",
                "password",
                "africa",
                "help poor ppl",
                2000,
                "22 Aug 22",
                100100100
        ));
        fundContributorDao.save(new FundContributor(
                1,
                "contributor",
                "contributor@gmail.com",
                "password",
                100100101,
                10000
        ));
        platformOwnerDao.save(new PlatformOwner(
                1,
                "owner",
                "owner@gmail.com",
                "password"
        ));
        
        for (int i = 1; i < 10; i++) {
            projectsDao.save(new Projects(
                    i,
                    "project " + i,
                    100 * i,
                    0
            ));
        }
    }
}