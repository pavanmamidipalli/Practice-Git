package com.example.TaskManager.DTO;
import com.example.TaskManager.util.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskManagerDTO extends BaseResponseDTO {
    private UUID id;
    private String tittle;
    private String description;
    private String status;
    private boolean isDeleted=false;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTIme;
}
