package com.example.fundraisingapp.controller;

import com.example.fundraisingapp.service.FundContributorService;
import com.example.fundraisingapp.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DonateProjectController {
    
    @Autowired
    private ProjectsService projectsService;
    
    @Autowired
    private FundContributorService fundContributorService;
    
    @GetMapping("/donate/project")
    public String donate(@RequestParam int projectId, @RequestParam String username) {
        boolean fundsAvailable = fundContributorService.checkIfFundsAvailable(username);
        if (!fundsAvailable) {
            return "User does not have funds";
        }
        projectsService.addFunds(100, projectId);
        fundContributorService.updateFunds(-100, username);
        return "Funds transferred";
    }
}