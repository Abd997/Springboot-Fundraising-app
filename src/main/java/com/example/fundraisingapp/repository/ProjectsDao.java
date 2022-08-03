package com.example.fundraisingapp.repository;

import com.example.fundraisingapp.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProjectsDao extends JpaRepository<Projects, Integer> {
    
    @Modifying
    @Transactional
    @Query("UPDATE Projects SET fundsGiven = :funds WHERE id = :id")
    void updateFunds(@Param("funds") int funds, @Param("id") int id);
    
    @Query("SELECT u.fundsGiven from Projects u WHERE u.id = :id")
    int getFundsGiven(@Param("id") int id);
}