package com.demo.comment.repositories;


import com.demo.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM comment WHERE parent_comment_id = :parentCommentId and post_id = :postId", nativeQuery=true)
    List<Comment> getChildCommentsOfComment(@Param("postId") Long postId, @Param("parentCommentId") Long parentCommentId);

}
