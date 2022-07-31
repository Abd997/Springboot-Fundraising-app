package com.example.fundraisingapp.repository;

import com.example.fundraisingapp.model.FundRaisers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface FundRaisersRepo extends JpaRepository<FundRaisers, Integer> {
    
    @Query("select u from FundRaisers u where u.username = :username")
    FundRaisers findByUsername(@Param("username") String username);
    
    @Query("select u.money from FundRaisers u where u.username = :username")
    int findUserMoney(@Param("username") String username);
    
    @Modifying
    @Transactional
    @Query("UPDATE FundRaisers SET money = :money where username = :username")
    void updateUserMoney(@Param("username") String username, @Param("money") int money);
}