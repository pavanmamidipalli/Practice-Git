package com.example.TaskManager.Controller;

import com.example.TaskManager.Service.Implementation.LogInService;
import com.example.TaskManager.model.LogIn;
import com.example.TaskManager.util.BaseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LogInController {
    @Autowired
    private LogInService logInService;
    @PostMapping("/save-credentials")
    public ResponseEntity<BaseResponseDTO> saveCredentials(@RequestBody LogIn logIn){
      return  logInService.saveCredentials(logIn);
    }

}
