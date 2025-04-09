package com.demo.comment.service;

import com.demo.comment.entity.Comment;
import com.demo.comment.model.CommentDetails;
import com.demo.comment.repositories.CommentRepository;
import com.demo.comment.repositories.LikeCommentRepository;
import com.demo.comment.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private UserRepository userRepository;
    private LikeCommentRepository likeCommentRepository;

    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, LikeCommentRepository likeCommentRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.likeCommentRepository = likeCommentRepository;
    }


    @Override
    public List<CommentDetails> listFirstLevelCommentOnPost(Long postId) {
        List<Comment> comments = commentRepository.getChildCommentsOfComment(postId, 0L);
        return comments.stream().filter(comment -> !comment.isDeleted()).map(this::getDetailsFromObject).collect(Collectors.toList());
    }

    @Override
    public Long add(Long postId, CommentDetails commentDetails) {
        return reply(postId, 0L, commentDetails);
    }

    @Override
    public Long edit(Long postId, Long commentId, CommentDetails commentDetails) throws Exception {

        Optional<Comment> optionalCommentFromDataBase = commentRepository.findById(commentId);
        if (optionalCommentFromDataBase.isPresent()) {
            Comment commentFromDataBase = optionalCommentFromDataBase.get();

            if (commentFromDataBase.getServiceUserId() != commentDetails.getUserId()
                    && commentFromDataBase.getPostId() != postId
                    && commentFromDataBase.getId() != commentId) {
                throw new Exception("Edit Not allowed");
            }
            createObjectFromDetails(commentFromDataBase, commentDetails);
            commentRepository.save(commentFromDataBase);
            return commentFromDataBase.getId();
        } else {
            throw new Exception("Not found");
        }
    }

    @Override
    public Long reply(Long postId, Long commentId, CommentDetails commentDetails) {
        Comment comment = new Comment();
        createObjectFromDetails(comment, commentDetails);
        comment.setCreateTime(new Date(System.currentTimeMillis()));
        comment.setPostId(postId);
        comment.setParentCommentId(commentId);
        return commentRepository.save(comment).getId();
    }


    @Override
    public void delete(int commentId) {

    }

    @Override
    public List<CommentDetails> listAllChildComments(Long postId, Long commentId) {
        List<Comment> comments = commentRepository.getChildCommentsOfComment(postId, commentId);
        return comments.stream().filter(comment -> !comment.isDeleted()).map(this::getDetailsFromObject).collect(Collectors.toList());
    }

    @Override
    public CommentDetails getById(Long postId, Long commentId) throws Exception {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isPresent() && !commentOptional.get().isDeleted()) {
            return getDetailsFromObject(commentOptional.get());
        } else {
            throw new Exception("Not Found");
        }
    }

    private void createObjectFromDetails(Comment comment, CommentDetails commentDetails) {
        comment.setText(commentDetails.getText());
        comment.setServiceUserId(commentDetails.getUserId());
    }

    private CommentDetails getDetailsFromObject(Comment comment) {
        CommentDetails commentDetails = new CommentDetails();
        commentDetails.setId(comment.getId());
        commentDetails.setCreateTime(comment.getCreateTime());
        commentDetails.setParentCommentId(comment.getParentCommentId());
        commentDetails.setUserId(comment.getServiceUserId());
        commentDetails.setText(comment.getText());
        commentDetails.setPostId(comment.getPostId());
        commentDetails.setUserName(userRepository.findById(comment.getServiceUserId()).get().getName());

        commentDetails.setNumberOfLikes(likeCommentRepository.listOfUsersLikes(comment.getPostId(), comment.getId()).size());
        commentDetails.setNumberOfDislikes(likeCommentRepository.listOfUsersDislikes(comment.getPostId(), comment.getId()).size());

        return commentDetails;
    }
}
