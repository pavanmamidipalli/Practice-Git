package com.example.TaskManager.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Types;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskManager {
    @Id
    @UuidGenerator
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;
    private String tittle;
    private String description;
    private String status;
    private boolean isDeleted=false;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime updatedTIme;
}
