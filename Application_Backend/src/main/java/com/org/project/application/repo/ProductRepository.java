package com.org.project.application.repo;

import com.org.project.application.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("select p.id from product p order by p.id desc ")
    List<String> getLastID();
}
