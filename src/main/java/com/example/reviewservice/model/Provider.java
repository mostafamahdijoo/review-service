package com.example.reviewservice.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "PROVIDER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Provider implements Serializable {

    private static final long serialVersionUID = 392012843718522494L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVIDER_SEQ")
    @SequenceGenerator(name = "PROVIDER_SEQ", sequenceName = "PROVIDER_SEQ")
    private Long id;

    @Column(name = "CORRELATION_ID")
    private String correlationId;

    @Column(name = "NAME")
    private String name;

}
