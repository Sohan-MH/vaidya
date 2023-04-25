package com.example.vaidya.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vaidya.model.UserLogin;

@Repository
public interface UserLogRepo extends JpaRepository<UserLogin,String>{

}
