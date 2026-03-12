package com.org.project.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "payment")
public class Payment {

    @Id
    @Column(name = "pay_ID")
    private String paymentID;

    private Date date;

    @OneToOne
    @JoinColumn(name = "order_ID")
    private Order order;
}
