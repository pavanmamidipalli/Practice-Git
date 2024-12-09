package com.example.TaskManager.repository;

import com.example.TaskManager.model.LogIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LogInRepository extends JpaRepository<LogIn, UUID> {
    LogIn findByUserName(String userName);
}
