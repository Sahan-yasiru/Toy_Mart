package com.org.project.application.service.impl;

import com.org.project.application.dto.DtoProduct;
import com.org.project.application.entity.Product;
import com.org.project.application.repo.ProductRepository;
import com.org.project.application.service.custom.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public void save(DtoProduct dto) {
        productRepository.save(modelMapper.map(dto, Product.class));

    }

    @Override
    public void update(DtoProduct dto) {
        productRepository.save(modelMapper.map(dto, Product.class));
    }

    @Override
    public List<DtoProduct> getAll() {
        return productRepository.findAll().stream().map(product -> modelMapper.map(product,DtoProduct.class)).toList();
    }

    @Override
    public String getLastID() {
        int id=Integer.parseInt(productRepository.getLastID().get(0).substring(1));
        return String.format("P%03d",id);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);

    }

    @Override
    public DtoProduct find(String id) {
        return modelMapper.map(productRepository.findById(id),DtoProduct.class);
    }
    @Override
    public boolean ifExit(String id) {
        return productRepository.existsById(id);
    }
}
