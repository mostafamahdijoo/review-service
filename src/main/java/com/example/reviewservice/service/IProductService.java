package com.example.reviewservice.service;

import com.example.reviewservice.dto.ProductDto;
import com.example.reviewservice.model.Product;

import java.util.List;

public interface IProductService {

    Product save(Product product);

    String saveNewProduct(ProductDto productDto);

    String updateProduct(ProductDto productDto);

    List<ProductDto> getVisibleProducts(Long endUserId);
}
