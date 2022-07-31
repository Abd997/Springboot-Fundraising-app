package com.example.fundraisingapp.controller;

import com.example.fundraisingapp.service.FundRaisersService;
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
    private FundRaisersService fundRaisersService;
    
    @GetMapping("/user/login")
    public ResponseEntity<?> checkUser(@RequestParam String username, @RequestParam String password) {
        if (authUser(username, password)) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    
    public boolean authUser(String username, String password) {
        return fundRaisersService.authenticate(username, password);
    }
}