package com.example.TaskManager.Service.Implementation;

import com.example.TaskManager.model.LogIn;
import com.example.TaskManager.repository.LogInRepository;
import com.example.TaskManager.util.ApplicationConstants;
import com.example.TaskManager.util.BaseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class LogInService {
    @Autowired
    private LogInRepository logInRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

    public ResponseEntity<BaseResponseDTO> saveCredentials(LogIn logIn){
        BaseResponseDTO baseResponseDTO= new BaseResponseDTO();
        try{
            if(!ObjectUtils.isEmpty(logIn)) {
                logIn.setPassword(bCryptPasswordEncoder.encode(logIn.getPassword()));
                logInRepository.save(logIn);
                baseResponseDTO.setMessage(ApplicationConstants.REGISTERED_SUCESSFULLY);
                return new ResponseEntity<>(baseResponseDTO, HttpStatus.OK);
            }
        }catch (Exception e){
            baseResponseDTO.setMessage(e.getLocalizedMessage());
            return new ResponseEntity<>(baseResponseDTO,HttpStatus.BAD_REQUEST);
        }
        baseResponseDTO.setMessage(ApplicationConstants.ERROR_WHILE_REGISTERING);
    return new ResponseEntity<>(baseResponseDTO,HttpStatus.BAD_REQUEST);
    }

}
