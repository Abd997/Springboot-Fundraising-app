package com.example.fundraisingapp.service;

import com.example.fundraisingapp.model.FundRaisers;
import com.example.fundraisingapp.repository.FundRaisersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FundRaisersService {
    
    @Autowired
    private FundRaisersRepo fundRaisersRepo;
    
    public List<FundRaisers> getAllFundRaisers() {
        List<FundRaisers> raisers = new ArrayList<FundRaisers>();
        fundRaisersRepo.findAll().forEach(raiser -> raisers.add(raiser));
        return raisers;
    }
    
    public FundRaisers getUser(String username) {
        return fundRaisersRepo.findByUsername(username);
    }
    
    public boolean authenticate(String username, String password) {
        boolean userExists = false;
        for (FundRaisers raisers : fundRaisersRepo.findAll()) {
            if (raisers.getUsername().equals(username)
                    && raisers.getPassword().equals(password)) {
                userExists = true;
                break;
            }
        }
        return userExists;
    }
    
    public void updateFunds(int money, String username) {
        int oldMoney = fundRaisersRepo.findUserMoney(username);
        int newMoney = oldMoney + money;
        fundRaisersRepo.updateUserMoney(username, newMoney);
    }
    
    public boolean checkIfFundsAvailable(String username) {
        int oldMoney = fundRaisersRepo.findUserMoney(username);
        return oldMoney != 0;
    }
}