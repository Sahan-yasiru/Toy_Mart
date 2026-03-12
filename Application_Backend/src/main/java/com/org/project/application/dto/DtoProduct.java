package com.org.project.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoProduct {
    private String id;
    private String name;
    private int qty;
    private DtoCategory category;
}
