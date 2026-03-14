package com.org.project.application;

import com.org.project.application.dto.DtoCategory;
import com.org.project.application.service.custom.CategoryService;
import com.org.project.application.service.custom.CustomerService;
import com.org.project.application.service.custom.OrderService;
import com.org.project.application.service.custom.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationBackendApplicationTests {
    @Autowired
    private PaymentService categoryService;
    @Test
    void contextLoads() {
        DtoCategory dtoCategory=new DtoCategory();
        dtoCategory.setId(4);
        dtoCategory.setName("jbl");
        System.out.println(categoryService.getAll());

        ;
    }

}
