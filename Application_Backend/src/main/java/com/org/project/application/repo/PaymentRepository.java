package com.org.project.application.repo;

import com.org.project.application.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

    @Query("select p.paymentID from payment p order by p.paymentID desc ")
    List<String> getLastID();
}
