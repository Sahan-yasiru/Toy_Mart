package com.org.project.application.repo;

import com.org.project.application.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    @Query("SELECT a.adminID FROM admin a ORDER BY a.adminID DESC")
    List<String> getLastID();


}

