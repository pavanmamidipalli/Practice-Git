package com.example.TaskManager.Service.Implementation;

import com.example.TaskManager.DTO.TaskManagerDTO;
import com.example.TaskManager.Entity.TaskManager;
import com.example.TaskManager.Service.Interface.TaskManagerService;
import com.example.TaskManager.repository.TaskManagerRepository;
import com.example.TaskManager.util.ApplicationConstants;
import com.example.TaskManager.util.BaseResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Slf4j
public class TaskManagerImplemetation implements TaskManagerService {
    @Autowired
    private TaskManagerRepository taskManagerRepository;
    @Autowired
   private ModelMapper modelMapper;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public ResponseEntity<BaseResponseDTO> saveTasks(TaskManagerDTO taskManagerDTO) {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        try{
            if(!ObjectUtils.isEmpty(taskManagerDTO)){
             TaskManager convetedEntity=  modelMapper.map(taskManagerDTO,TaskManager.class);
                taskManagerRepository.save(convetedEntity);
                baseResponseDTO.setMessage(ApplicationConstants.TASK_SAVED_SUCCESS);
                return new ResponseEntity<>(baseResponseDTO, HttpStatus.OK);
            }
        }
        catch (Exception e){

            log.error(e.getLocalizedMessage());
        }
        baseResponseDTO.setMessage(ApplicationConstants.ERROR_SAVING_TASK);
        return new ResponseEntity<>(baseResponseDTO,HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<TaskManagerDTO>> getAllTasks() {
        List<TaskManagerDTO> taskManagerDTOS=new ArrayList<>();
      try{
         List<TaskManager> taskManager= taskManagerRepository.findAll().stream().filter(task->!task.isDeleted()).toList();
         if(!ObjectUtils.isEmpty(taskManager)){
        List<TaskManagerDTO> fetechedDTO= taskManager.stream().map(taskManager1 -> modelMapper.map(taskManager1,TaskManagerDTO.class)).collect(Collectors.toList());
             return  new ResponseEntity<>(fetechedDTO,HttpStatus.OK);
         }

      }catch (Exception e){
          log.error(e.getLocalizedMessage());
      }
      return  new ResponseEntity<>(taskManagerDTOS,HttpStatus.BAD_REQUEST);
    }


    @Override
    public ResponseEntity<BaseResponseDTO> updateTask(TaskManagerDTO taskManagerDTO) {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();

        try {
            TaskManager existingTaskManager = taskManagerRepository.findById(taskManagerDTO.getId()).orElseThrow(RuntimeException::new);
            if (!ObjectUtils.isEmpty(existingTaskManager)) {
                TaskManager taskManager= objectMapper.readerForUpdating(existingTaskManager).readValue(objectMapper.writeValueAsBytes(taskManagerDTO));
                  taskManagerRepository.save(taskManager);
                baseResponseDTO.setMessage(ApplicationConstants.TASK_UPDATED_SUCESSFULLY);
                return new ResponseEntity<>(baseResponseDTO, HttpStatus.OK);
            }
        }catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
        baseResponseDTO.setMessage(ApplicationConstants.ERROR_UPDATING_TASKS);
        return new ResponseEntity<>(baseResponseDTO,HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<BaseResponseDTO> deteleTasks(UUID id) {
        BaseResponseDTO baseResponseDTO= new BaseResponseDTO();
        try{
       TaskManager taskManager=  taskManagerRepository.findById(id).orElseThrow(RuntimeException::new);
       if(!ObjectUtils.isEmpty(taskManager)&& !taskManager.isDeleted()){
           taskManager.setDeleted(true);
           taskManagerRepository.save(taskManager);
           baseResponseDTO.setMessage(ApplicationConstants.DELETED_SUCCESSFULLY);
           return new ResponseEntity<>(baseResponseDTO,HttpStatus.OK);
       }
        }catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
        baseResponseDTO.setMessage(ApplicationConstants.ERROR_DELETING);
        return new ResponseEntity<>(baseResponseDTO,HttpStatus.BAD_REQUEST);
    }
}
