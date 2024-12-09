package com.example.TaskManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Types;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogIn {
    @Id
    @UuidGenerator
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;
    private String userName;
    private String password;
}
