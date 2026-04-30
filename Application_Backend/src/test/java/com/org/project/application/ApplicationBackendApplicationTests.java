package com.org.project.application;

import com.org.project.application.dto.DtoCategory;
import com.org.project.application.service.custom.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationBackendApplicationTests {
    @Autowired
    private PaymentService paymentService;
    @Test
    void contextLoads() {

        try {
            paymentService.delete("P001");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ;
    }

}
