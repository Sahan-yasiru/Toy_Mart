package com.org.project.application.config;

import com.org.project.application.dto.DtoAdmin;
import com.org.project.application.service.custom.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {
    private AdminService adminService;

    @Autowired
    AdminConfig(AdminService adminService) throws Exception {
        this.adminService=adminService;
        addDefultAdmin();
    }

    private void addDefultAdmin() throws Exception {
        if(adminService.getAll().isEmpty()){
            adminService.save(new DtoAdmin("A001","admin","admin"));
        }
    }

}