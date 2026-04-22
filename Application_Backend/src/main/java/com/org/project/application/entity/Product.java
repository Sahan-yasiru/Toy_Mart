package com.org.project.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {

    @Id
    private String id;

    private String name;

    private int qty;

    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}