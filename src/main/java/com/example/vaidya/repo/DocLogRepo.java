package com.example.vaidya.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vaidya.model.DocLogin;

@Repository
public interface DocLogRepo extends JpaRepository<DocLogin,String>{

}
