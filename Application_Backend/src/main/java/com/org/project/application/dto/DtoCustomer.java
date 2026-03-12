package com.org.project.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoCustomer {
    private String customer_ID;
    private String name;
    private  String eMail;
    private String passWord;

}
