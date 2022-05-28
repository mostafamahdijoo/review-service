package com.example.reviewservice.repository;

import com.example.reviewservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query( " select e.id as id, " +
//            "        e.correlationId as correlationId, " +
//            "        e.name as name, " +
//            "        e.isVisible as isVisible, " +
//            "        e.commentEnabled as commentEnabled, " +
//            "        e.voteEnabled as voteEnabled," +
//            "        e.provider.id as providerId, " +
//            "        (  select  id " +
//            "           from    UserOrderProduct uop " +
//            "           where   uop.product.id = e.id and " +
//            "                    " +
//            "        ) as userCanComment" +
//            " from Product e " +
//            " left join UserOrderProduct uop " +
//            " where exists( " +
//            "           select  uo.id " +
//            "           from    UserOrder uo " +
//            "           where   uo.endUser.id = :endUserId and " +
//            "                   uop.userOrder.id = uo.id) " )
//    List<ProductDto> getVisibleProducts(@Param("endUserId") Long endUserId);

    List<Product> getAllByIsVisible(Boolean isVisible);

}
