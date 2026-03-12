package com.org.project.application.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name ="category" )
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> products;



}
