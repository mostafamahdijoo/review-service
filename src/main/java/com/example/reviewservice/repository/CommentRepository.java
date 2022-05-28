package com.example.reviewservice.repository;

import com.example.reviewservice.model.Comment;
import com.example.reviewservice.model.enums.CommentState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(
        " select avg(e.voteScore) " +
        " from Comment e " +
        " where e.product.id = :productId and e.commentState = :commentState"
    )
    Double getAverageVoteScoreByProductIdAndState(@Param("productId") Long productId, @Param("commentState") CommentState commentState);


    List<Comment> findTop3ByProductIdOrderByCreatedDateDesc(Long productId);
}
