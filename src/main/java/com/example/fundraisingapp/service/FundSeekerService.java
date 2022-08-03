package com.example.fundraisingapp.service;

import com.example.fundraisingapp.model.FundSeeker;
import com.example.fundraisingapp.repository.FundSeekerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundSeekerService {
    
    @Autowired
    private FundSeekerDao fundSeekerDao;
    
    public boolean authenticate(String username, String password) {
        boolean userExists = false;
        for (FundSeeker seeker : fundSeekerDao.findAll()) {
            if (seeker.getUsername().equals(username)
                    && seeker.getPassword().equals(password)) {
                userExists = true;
                break;
            }
        }
        return userExists;
    }
}
