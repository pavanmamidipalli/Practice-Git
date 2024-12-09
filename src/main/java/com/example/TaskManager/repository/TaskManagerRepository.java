package com.example.TaskManager.repository;

import com.example.TaskManager.Entity.TaskManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TaskManagerRepository extends JpaRepository<TaskManager, UUID> {

}
