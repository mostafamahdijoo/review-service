package com.example.reviewservice.dto;

import com.example.reviewservice.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String correlationId;
    private String name;
    private Boolean isVisible;
    private Boolean commentEnabled;
    private Boolean voteEnabled;
    private Long providerId;
    private Double averageVoteScore;
    private List<Comment> lastThreeComments;

    private Boolean userCanComment;
}
