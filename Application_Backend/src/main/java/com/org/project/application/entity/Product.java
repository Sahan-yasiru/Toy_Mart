package com.org.project.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private int qty;

    @ManyToOne
    @JoinColumn(name = "category_ID")
    private Category category;


}
