package com.org.project.application.service.impl;

import com.org.project.application.dto.DtoCategory;
import com.org.project.application.dto.DtoProduct;
import com.org.project.application.entity.Category;
import com.org.project.application.repo.CategoryRepository;
import com.org.project.application.service.custom.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private  final ModelMapper modelMapper;

    @Override
    public void save(DtoCategory dto) {
        categoryRepository.save(modelMapper.map(dto, Category.class));
    }


    //remember to verify before update
    @Override
    public void update(DtoCategory dto) {
        categoryRepository.save(modelMapper.map(dto,Category.class));

    }

    @Override
    @Transactional
    public List<DtoCategory> getAll() {
        List<DtoCategory> categories=new ArrayList<>();
        return categoryRepository.findAll().stream().map(category -> {

            DtoCategory dtoCategory = new DtoCategory();
            dtoCategory.setId(category.getId());
            dtoCategory.setName(category.getName());

            List<DtoProduct> dtoProducts=category.getProducts().stream().map(product -> modelMapper.map(product,DtoProduct.class)).toList();
            dtoCategory.setProducts(dtoProducts);
            return dtoCategory;
        }).toList();
    }

    @Override
    public String getLastID() {
        return "";
    }

    @Override
    public void delete(String id) {
        categoryRepository.deleteById(Integer.parseInt(id));
    }

    @Override
    public DtoCategory find(String id) {
        return modelMapper.map(categoryRepository.findById(Integer.parseInt(id)),DtoCategory.class);
    }

    @Override
    public long getCount() {
        return categoryRepository.count();
    }
    @Override
    public boolean ifExit(String id) {
        return categoryRepository.existsById(Integer.parseInt(id));
    }
}
