package com.org.project.application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Admin {

    @Id
    private String adminId;

    @Column(nullable = false, unique = true)
    private String userName;

    private String password;

}
