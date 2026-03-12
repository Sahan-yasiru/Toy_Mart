package com.org.project.application.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "customer_order")
public class Order {
    @Id
    private String orderID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cus_ID")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_ID"),
            inverseJoinColumns = @JoinColumn(name = "product_ID")
    )
    private List<Product> products;
}