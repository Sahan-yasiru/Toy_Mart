package com.org.project.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {

    @Id
    private String paymentId;

    private Date date;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}