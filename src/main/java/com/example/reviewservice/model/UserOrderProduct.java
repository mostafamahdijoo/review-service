package com.example.reviewservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "USER_ORDER_PRODUCT")
public class UserOrderProduct implements Serializable {

    private static final long serialVersionUID = 392012843718522694L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ORDER_PRODUCT_SEQ")
    @SequenceGenerator(name = "USER_ORDER_PRODUCT_SEQ", sequenceName = "USER_ORDER_PRODUCT_SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn
    private UserOrder userOrder;

    @ManyToOne
    @JoinColumn
    private Product product;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    private Double price;

    @NotNull
    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;
}