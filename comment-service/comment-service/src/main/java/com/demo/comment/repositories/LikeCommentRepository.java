package com.demo.comment.repositories;


import com.demo.comment.entity.LikeComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeCommentRepository extends JpaRepository<LikeComment, Long> {

    @Query(value = "SELECT * FROM like_comment WHERE comment_id = :commentId and service_user_id = :userId and post_id = :postId LIMIT 1", nativeQuery=true)
    LikeComment isPresent(@Param("postId") Long postId, @Param("commentId") Long commentId, @Param("userId") Long userId);


    @Query(value = "SELECT * FROM like_comment WHERE is_like = true and comment_id = :commentId and post_id = :postId", nativeQuery=true)
    List<LikeComment> listOfUsersLikes(@Param("postId") Long postId, @Param("commentId") Long commentId);

    @Query(value = "SELECT * FROM like_comment WHERE is_like = false and comment_id = :commentId and post_id = :postId", nativeQuery=true)
    List<LikeComment> listOfUsersDislikes(@Param("postId") Long postId, @Param("commentId") Long commentId);

}
