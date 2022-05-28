package com.example.reviewservice.service;

import com.example.reviewservice.model.Comment;
import com.example.reviewservice.model.enums.CommentState;

import java.util.List;

public interface ICommentService {

    Double getAverageVoteScoreByProductId(Long productId);

    List<Comment> findTop3ByProductOrderByCreatedDateDesc(Long productId);
}
