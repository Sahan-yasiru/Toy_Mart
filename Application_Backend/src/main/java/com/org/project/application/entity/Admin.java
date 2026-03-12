package com.org.project.application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "admin")
public class Admin {
    @Id
    private String adminID;
    @Column(name = "username",nullable = false)
    private String userName;
    @Column(name = "password",nullable = false)
    private String password;



}
