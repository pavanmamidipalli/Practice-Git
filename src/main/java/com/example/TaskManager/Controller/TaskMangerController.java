package com.example.TaskManager.Controller;

import com.example.TaskManager.DTO.TaskManagerDTO;
import com.example.TaskManager.Entity.TaskManager;
import com.example.TaskManager.Service.Implementation.TaskManagerImplemetation;
import com.example.TaskManager.Service.Interface.TaskManagerService;
import com.example.TaskManager.util.BaseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:5173")
public class TaskMangerController {
    @Autowired
    private TaskManagerService taskManagerService;
    @PostMapping("/post-tasks")
    public ResponseEntity<BaseResponseDTO> saveTasks(@RequestBody TaskManagerDTO taskManagerDTO){
        return taskManagerService.saveTasks(taskManagerDTO);
    }
    @GetMapping("/get-all-tasks")
    public ResponseEntity<List<TaskManagerDTO>> getAllTasks(){
        return taskManagerService.getAllTasks();
    }
    @PutMapping("/update-tasks")
    public ResponseEntity<BaseResponseDTO> updateTask(@RequestBody TaskManagerDTO taskManagerDTO){
        return taskManagerService.updateTask(taskManagerDTO);
    }
    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity<BaseResponseDTO> deteleTasks(@PathVariable UUID id){
        return taskManagerService.deteleTasks(id);
    }

}
