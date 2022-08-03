package com.example.fundraisingapp.service;

import com.example.fundraisingapp.model.PlatformOwner;
import com.example.fundraisingapp.repository.PlatformOwnerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformOwnerService {
    
    @Autowired
    private PlatformOwnerDao platformOwnerDao;
    
    public boolean authenticate(String username, String password) {
        boolean userExists = false;
        for (PlatformOwner owner : platformOwnerDao.findAll()) {
            if (owner.getUsername().equals(username)
                    && owner.getPassword().equals(password)) {
                userExists = true;
                break;
            }
        }
        return userExists;
    }
}
