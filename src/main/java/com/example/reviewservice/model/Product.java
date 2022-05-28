package com.example.reviewservice.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = -6877217786147467270L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
    @SequenceGenerator(name = "PRODUCT_SEQ", sequenceName = "PRODUCT_SEQ")
    private Long id;

    @Column(name = "CORRELATION_ID")
    private String correlationId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_VISIBLE")
    private Boolean isVisible;

    @Column(name = "COMMENT_ENABLED")
    private Boolean commentEnabled;

    @Column(name = "VOTE_ENABLED")
    private Boolean voteEnabled;

    @ManyToOne
    @JoinColumn
    private Provider provider;

}
