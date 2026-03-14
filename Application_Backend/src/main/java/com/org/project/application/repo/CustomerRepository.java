package com.org.project.application.repo;

import com.org.project.application.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query("SELECT c.customer_ID FROM customer c ORDER BY c.customer_ID DESC")
    List<String> getLastID();

}
