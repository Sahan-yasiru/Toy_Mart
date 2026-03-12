package com.org.project.application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "customer")
public class Customer {
    @Id
    private String customer_ID;

    @Column(nullable = false)
    private String name;

    @Column(name = "E-Mail",nullable = false,unique = true)
    private  String eMail;

    @Column(name = "password",nullable = false)
    private String passWord;

}
