package com.example.reviewservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "USER_ORDER")
public class UserOrder implements Serializable {

    private static final long serialVersionUID = 8197975492563584685L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ORDER_SEQ")
    @SequenceGenerator(name = "USER_ORDER_SEQ", sequenceName = "USER_ORDER_SEQ")
    private Long id;

    @NotNull
    @Column(name = "ORDER_NUMBER", unique = true, nullable = false,length = 50)
    private String orderNumber;

    @Column(name = "ORDER_DATE")
    private Instant orderDate;

    @ManyToOne(fetch = FetchType.LAZY,
            targetEntity = EndUser.class)
    @JoinColumn(name = "END_USER_ID")
    private EndUser endUser;
}