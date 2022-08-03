package com.example.fundraisingapp.service;

import com.example.fundraisingapp.model.FundContributor;
import com.example.fundraisingapp.repository.FundContributorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FundContributorService {
    
    @Autowired
    private FundContributorDao fundContributorDao;
    
    public List<FundContributor> getAllFundRaisers() {
        List<FundContributor> raisers = new ArrayList<FundContributor>();
        fundContributorDao.findAll().forEach(raiser -> raisers.add(raiser));
        return raisers;
    }
    
    public FundContributor getUser(String username) {
        return fundContributorDao.findByUsername(username);
    }
    
    public boolean authenticate(String username, String password) {
        boolean userExists = false;
        for (FundContributor raisers : fundContributorDao.findAll()) {
            if (raisers.getUsername().equals(username)
                    && raisers.getPassword().equals(password)) {
                userExists = true;
                break;
            }
        }
        return userExists;
    }
    
    public void updateFunds(int money, String username) {
        int oldMoney = fundContributorDao.findUserMoney(username);
        int newMoney = oldMoney + money;
        fundContributorDao.updateUserMoney(username, newMoney);
    }
    
    public boolean checkIfFundsAvailable(String username) {
        int oldMoney = fundContributorDao.findUserMoney(username);
        return oldMoney != 0;
    }
}