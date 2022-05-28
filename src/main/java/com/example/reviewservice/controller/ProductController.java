package com.example.reviewservice.controller;

import com.example.reviewservice.dto.ProductDto;
import com.example.reviewservice.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final IProductService iProductService;

    @PostMapping(value = "/saveNewProduct")
    @ResponseBody
    public ResponseEntity<String> saveNewProduct(@RequestBody ProductDto productDto) {
        String savedProductCorrelationId = iProductService.saveNewProduct(productDto);
        return new ResponseEntity<>(savedProductCorrelationId, HttpStatus.OK);
    }

    @PostMapping(value = "/updateProduct")
    @ResponseBody
    public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto) {
        String savedProductCorrelationId = iProductService.updateProduct(productDto);
        return new ResponseEntity<>(savedProductCorrelationId, HttpStatus.OK);
    }

    @GetMapping(value = "/getVisibleProducts/{end_user_id}")
    @ResponseBody
    public ResponseEntity<List<ProductDto>> getVisibleProducts(@PathVariable(name = "end_user_id") Long endUserId) {
        List<ProductDto> productDtoList = iProductService.getVisibleProducts(endUserId);
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

}
