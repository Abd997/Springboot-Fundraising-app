package com.example.fundraisingapp.repository;

import com.example.fundraisingapp.model.FundSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundSeekerDao extends JpaRepository<FundSeeker, Integer> {
    
}
