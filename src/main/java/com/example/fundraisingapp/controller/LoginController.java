package com.example.fundraisingapp.controller;

import com.example.fundraisingapp.service.FundContributorService;
import com.example.fundraisingapp.service.FundSeekerService;
import com.example.fundraisingapp.service.PlatformOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class LoginController {
    
    @Autowired
    private FundContributorService fundContributorService;
    
    @Autowired
    private FundSeekerService fundSeekerService;
    
    @Autowired
    private PlatformOwnerService platformOwnerService;
    
    @GetMapping("/user/login")
    public ResponseEntity<?> checkUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String userType
    ) {
        if (userType.equals("fund seeker")) {
            boolean userExists = fundSeekerService.authenticate(username, password);
            if (userExists) {
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else if (userType.equals("fund contributor")) {
            boolean userExists = fundContributorService.authenticate(username, password);
            if (userExists) {
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else if (userType.equals("platform owner")) {
            boolean userExists = platformOwnerService.authenticate(username, password);
            if (userExists) {
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}