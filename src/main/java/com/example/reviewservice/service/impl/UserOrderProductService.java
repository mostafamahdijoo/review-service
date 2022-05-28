package com.example.reviewservice.service.impl;

import com.example.reviewservice.model.Product;
import com.example.reviewservice.repository.UserOrderProductRepository;
import com.example.reviewservice.service.IUserOrderProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserOrderProductService implements IUserOrderProductService {

    private final UserOrderProductRepository userOrderProductRepository;

    @Override
    public List<Product> getUserOrderedProducts(Long endUserId) {
        return userOrderProductRepository.getUserOrderedProducts(endUserId);
    }
}
