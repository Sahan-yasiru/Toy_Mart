package com.org.project.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoCategory {
    public int id;
    private String name;
    private List<DtoProduct> products;

}
