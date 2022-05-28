package com.example.reviewservice.service.impl;

import com.example.reviewservice.dto.ProductDto;
import com.example.reviewservice.model.Product;
import com.example.reviewservice.model.Provider;
import com.example.reviewservice.repository.ProductRepository;
import com.example.reviewservice.service.ICommentService;
import com.example.reviewservice.service.IProductService;
import com.example.reviewservice.service.IUserOrderProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    private final IUserOrderProductService iUserOrderProductService;

    private final ICommentService iCommentService;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public String saveNewProduct(ProductDto productDto) {
        Product product;
        Provider provider = Provider.builder().id(productDto.getProviderId()).build();
        if(productDto != null) {
            product = Product.builder()
                    .name(productDto.getName())
                    .isVisible(productDto.getIsVisible())
                    .commentEnabled(productDto.getCommentEnabled())
                    .voteEnabled(productDto.getVoteEnabled())
                    .correlationId(UUID.randomUUID().toString())
                    .provider(provider)
                    .build();
            return save(product).getCorrelationId();
        }
        else {
            return null;
        }
    }

    @Override
    @Transactional
    public String updateProduct(ProductDto productDto) {
        Product product = Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .isVisible(productDto.getIsVisible())
                .commentEnabled(productDto.getCommentEnabled())
                .voteEnabled(productDto.getVoteEnabled())
                .build();
        return save(product).getCorrelationId();
    }

    @Override
    public List<ProductDto> getVisibleProducts(Long endUserId) {
        List<ProductDto> productDtoList = new LinkedList<>();

        List<Product> visibleProducts = productRepository.getAllByIsVisible(Boolean.TRUE);
        List<Product> userOrderedProducts = iUserOrderProductService.getUserOrderedProducts(endUserId);

        visibleProducts.forEach(product -> {
            ProductDto productDto = ProductDto.builder()
                    .id(product.getId())
                    .correlationId(product.getCorrelationId())
                    .name(product.getName())
                    .isVisible(product.getIsVisible())
                    .commentEnabled(product.getCommentEnabled())
                    .voteEnabled(product.getVoteEnabled())
                    .providerId(product.getProvider().getId())
                    .userCanComment(Boolean.FALSE)
                    .build();

            boolean userBoughtProductBefore = userOrderedProducts.stream().anyMatch(userOrderedProduct -> product.getId().equals(userOrderedProduct.getId()));

            if(userBoughtProductBefore) {
                productDto.setUserCanComment(Boolean.TRUE);
            }

            productDto.setAverageVoteScore(iCommentService.getAverageVoteScoreByProductId(product.getId()));
            productDto.setLastThreeComments(iCommentService.findTop3ByProductOrderByCreatedDateDesc(product.getId()));

            productDtoList.add(productDto);
        });

        return productDtoList;
    }
}
