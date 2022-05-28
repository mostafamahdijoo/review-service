package com.example.reviewservice.repository;

import com.example.reviewservice.model.Product;
import com.example.reviewservice.model.UserOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserOrderProductRepository extends JpaRepository<UserOrderProduct, Long> {

    @Query(
            " select e.product " +
            " from UserOrderProduct e " +
            " where e.userOrder.id = :endUserId "
    )
    List<Product> getUserOrderedProducts(@Param("endUserId") Long endUserId);

}
