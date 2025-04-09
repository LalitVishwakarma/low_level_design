package com.demo.likeservice.service;

import com.demo.likeservice.entity.LikeComment;
import com.demo.likeservice.model.LikeCommentDetails;
import com.demo.likeservice.repositories.LikeCommentRepository;
import com.demo.likeservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeCommentServiceImpl implements LikeCommentService {


    private LikeCommentRepository likeCommentRepository;
    private UserRepository userRepository;

    public LikeCommentServiceImpl(LikeCommentRepository likeCommentRepository, UserRepository userRepository) {
        this.likeCommentRepository = likeCommentRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Long add(Long postId, Long commentId, LikeCommentDetails likeCommentDetails, boolean like) throws Exception {
        try {
            LikeComment likeCommentFromDataBase = likeCommentRepository.isPresent(
                    commentId,
                    likeCommentDetails.getUserId(),
                    postId);
            if (likeCommentFromDataBase != null) {
                updateDetailsInObject(likeCommentFromDataBase, likeCommentDetails, like);
                likeCommentRepository.save(likeCommentFromDataBase);
                return likeCommentFromDataBase.getId();
            } else {
                LikeComment likeComment = new LikeComment();
                likeComment.setCreateTime(new Date(System.currentTimeMillis()));
                updateDetailsInObject(likeComment, likeCommentDetails, like);
                likeComment.setPostId(postId);
                likeComment.setCommentId(commentId);
                return likeCommentRepository.save(likeComment).getId();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<LikeCommentDetails> getLikesOnPost(Long postId) {
        return getLikesOnComment(postId, 0L);
    }

    @Override
    public List<LikeCommentDetails> getLikesOnComment(Long postId, Long commentId) {
        List<LikeComment> likeComments = likeCommentRepository.listOfUsersLikes(postId, commentId);
        return likeComments.stream().map(this::getDetailsFromObject).collect(Collectors.toList());
    }

    @Override
    public List<LikeCommentDetails> getDislikesOnPost(Long postId) {
        return getDislikesOnComment(postId, 0L);
    }

    @Override
    public List<LikeCommentDetails> getDislikesOnComment(Long postId, Long commentId) {
        List<LikeComment> likeComments = likeCommentRepository.listOfUsersDislikes(postId, commentId);
        return likeComments.stream().map(this::getDetailsFromObject).collect(Collectors.toList());
    }

    private void updateDetailsInObject(LikeComment likeCommentFromDataBase, LikeCommentDetails likeCommentDetails, boolean like) {
        likeCommentFromDataBase.setLike(like);
        likeCommentFromDataBase.setServiceUserId(likeCommentDetails.getUserId());
    }

    private LikeCommentDetails getDetailsFromObject(LikeComment likeComment) {
        LikeCommentDetails details = new LikeCommentDetails();
        details.setCommentId(likeComment.getCommentId());
        details.setUserId(likeComment.getServiceUserId());
        details.setPostId(likeComment.getPostId());
        details.setUserName(userRepository.findById(likeComment.getServiceUserId()).get().getName());
        return details;
    }

    @Override
    public Long deleteALike(Long userId, Long postId, Long commentId){
        likeCommentRepository.deleteALike(userId, postId, commentId);
    }
}
