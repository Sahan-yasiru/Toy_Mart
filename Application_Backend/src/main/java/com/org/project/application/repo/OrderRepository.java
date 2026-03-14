package com.org.project.application.repo;

import com.org.project.application.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {

    @Query("SELECT o.orderID FROM customer_order o ORDER BY o.orderID DESC")
    List<String> getLastID();

}
