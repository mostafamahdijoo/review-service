package com.example.reviewservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "END_USER")
@Getter
@Setter
@NoArgsConstructor
public class EndUser {

    private static final long serialVersionUID = 3893550904508060821L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "END_USER_SEQ")
    @SequenceGenerator(name = "END_USER_SEQ", sequenceName = "END_USER_SEQ")
    private Long id;

    @NonNull
    @Column(name = "USER_NAME", length = 50, unique = true, nullable = false)
    private String username;

    @JsonIgnore
    @Column(name = "PASSWORD_HASH")
    private String password;

}