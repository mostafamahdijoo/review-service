package com.example.reviewservice.service.impl;

import com.example.reviewservice.model.Comment;
import com.example.reviewservice.model.enums.CommentState;
import com.example.reviewservice.repository.CommentRepository;
import com.example.reviewservice.service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService {

    private final CommentRepository commentRepository;

    @Override
    public Double getAverageVoteScoreByProductId(Long productId) {
        return commentRepository.getAverageVoteScoreByProductIdAndState(productId, CommentState.APPROVED);
    }

    @Override
    public List<Comment> findTop3ByProductOrderByCreatedDateDesc(Long productId) {
        return commentRepository.findTop3ByProductIdOrderByCreatedDateDesc(productId);
    }
}
