package com.example.reviewservice.model;

import com.example.reviewservice.model.enums.CommentState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "COMMENT")
public class Comment implements Serializable {

    private static final long serialVersionUID = 392012743714522494L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_SEQ")
    @SequenceGenerator(name = "COMMENT_SEQ", sequenceName = "COMMENT_SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn
    private EndUser endUser;

    @ManyToOne
    @JoinColumn
    private Product product;

    @Column(name = "TEXT")
    private String text;

    @NotNull
    @Column(name = "VOTE_SCORE")
    private Double voteScore;

    @Column(name = "STATE")
    @Enumerated(EnumType.STRING)
    private CommentState commentState = CommentState.REGISTERED;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;

}
