package com.example.reviewservice.service;

import com.example.reviewservice.model.Product;

import java.util.List;

public interface IUserOrderProductService {

    List<Product> getUserOrderedProducts(Long endUserId);
}
