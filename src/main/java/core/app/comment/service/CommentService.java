package core.app.comment.service;

import core.app.comment.entity.Comment;
import core.app.comment.repository.CommentRepository;
import core.app.exception.BusinessLogicException;
import core.app.exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Comment comment){
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment){
        Comment findComment = findComment(comment.getCommentId());
        Optional.ofNullable(comment.getComment())
                .ifPresent(findComment::setComment);
        Comment updateComment = commentRepository.save(findComment);

        return updateComment;
    }
    public void deleteComment(Long commentId){
        Comment comment = findComment(commentId);
        commentRepository.deleteById(commentId);
    }

    public Comment findComment(Long commentId){
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        Comment findComment = optionalComment.orElseThrow(()->new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));

        return findComment;
    }

    public Page<Comment> findComments(int page, int size){
        return commentRepository.findAll(PageRequest.of(page,size, Sort.by("questionId").descending()));
    }


}
