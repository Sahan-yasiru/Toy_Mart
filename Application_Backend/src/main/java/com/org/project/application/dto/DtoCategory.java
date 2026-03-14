package com.org.project.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoCategory {
    public int id;
    private String name;

    @ToString.Exclude
    private List<DtoProduct> products;

}
