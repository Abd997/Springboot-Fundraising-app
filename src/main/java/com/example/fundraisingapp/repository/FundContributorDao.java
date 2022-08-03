package com.example.fundraisingapp.repository;

import com.example.fundraisingapp.model.FundContributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface FundContributorDao extends JpaRepository<FundContributor, Integer> {
    
    @Query("select u from FundContributor u where u.username = :username")
    FundContributor findByUsername(@Param("username") String username);
    
    @Query("select u.money from FundContributor u where u.username = :username")
    int findUserMoney(@Param("username") String username);
    
    @Modifying
    @Transactional
    @Query("UPDATE FundContributor SET money = :money where username = :username")
    void updateUserMoney(@Param("username") String username, @Param("money") int money);
}