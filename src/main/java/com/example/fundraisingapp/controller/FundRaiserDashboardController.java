package com.example.fundraisingapp.controller;

import com.example.fundraisingapp.service.FundRaisersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RestController
public class FundRaiserDashboardController {
    
    @Autowired
    private FundRaisersService fundRaisersService;
    
    @GetMapping("/fundraiser/dashboard")
    public String getDashboard(Model model, @RequestParam String username) {
        model.addAttribute("user", fundRaisersService.getUser(username));
        return "fundRaiserDashboard";
//        return fundRaisersService.getUser("user").getUsername();
    }
}