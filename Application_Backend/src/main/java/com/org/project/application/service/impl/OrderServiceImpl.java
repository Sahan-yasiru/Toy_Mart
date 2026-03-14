package com.org.project.application.service.impl;

import com.org.project.application.dto.DtoCustomer;
import com.org.project.application.dto.DtoOrder;
import com.org.project.application.dto.DtoProduct;
import com.org.project.application.entity.Order;
import com.org.project.application.repo.OrderRepository;
import com.org.project.application.service.custom.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void save(DtoOrder dto) {
        orderRepository.save(modelMapper.map(dto, Order.class));
    }

    @Override
    public void update(DtoOrder dto) {
        orderRepository.save(modelMapper.map(dto, Order.class));
    }

    @Override
    public List<DtoOrder> getAll() {
        // Fetch all orders from DB
        List<Order> orders = orderRepository.findAll();

        // Map each order to a DtoOrder manually
        return orders.stream().map(order -> {
            DtoOrder dto = new DtoOrder();

            // Map basic order info
            dto.setOrderID(order.getOrderID());

            // Map customer using ModelMapper
            dto.setCustomer(modelMapper.map(order.getCustomer(), DtoCustomer.class));

            // Map products manually to DTO list
            List<DtoProduct> productDtos = order.getProducts()
                    .stream()
                    .map(product -> modelMapper.map(product, DtoProduct.class))
                    .toList();
            dto.setProducts(productDtos);

            return dto;
        }).toList();

    }

    @Override
    public String getLastID() {
        int id= Integer.parseInt(orderRepository.getLastID().get(0).substring(1));
        return String.format("O%03d",++id);
    }

    @Override
    public void delete(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public DtoOrder find(String id) {
        return modelMapper.map(orderRepository.findById(id),DtoOrder.class);
    }
    @Override
    public boolean ifExit(String id) {
        return orderRepository.existsById(id);
    }
}
