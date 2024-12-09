package com.example.TaskManager.Service.Interface;

import com.example.TaskManager.DTO.TaskManagerDTO;
import com.example.TaskManager.Entity.TaskManager;
import com.example.TaskManager.util.BaseResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface TaskManagerService {
    ResponseEntity<BaseResponseDTO> saveTasks(TaskManagerDTO taskManagerDTO);
    ResponseEntity<List<TaskManagerDTO>> getAllTasks();
    ResponseEntity<BaseResponseDTO> updateTask(TaskManagerDTO taskManagerDTO);
    ResponseEntity<BaseResponseDTO> deteleTasks(UUID id);
}
