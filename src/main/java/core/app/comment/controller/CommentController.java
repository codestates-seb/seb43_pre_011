package core.app.comment.controller;


import core.app.comment.dto.CommentDto;
import core.app.comment.dto.CommentPatchDto;
import core.app.comment.dto.CommentPostDto;
import core.app.comment.entity.Comment;
import core.app.comment.mapper.CommentMapper;
import core.app.comment.service.CommentService;
import core.app.dto.SingleResponseDto;
import core.app.member.service.MemberService;
import core.app.question.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/comments") // /question/{question-id}/comments
@Slf4j
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper mapper;
    private final MemberService memberService;
    private final QuestionService questionService;

    @Autowired
    public CommentController(CommentService commentService, CommentMapper mapper, MemberService memberService, QuestionService questionService) {
        this.commentService = commentService;
        this.mapper = mapper;
        this.memberService = memberService;
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity postComment(@Valid @RequestBody CommentDto.Post requestBody){



        Comment comment = mapper.commentPostDtoToComment(requestBody);

        Comment createComment = commentService.createComment(comment);

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.commentToCommentResponseDto(createComment)), HttpStatus.CREATED);
    }

    @PatchMapping("/{comment-id}")
    public ResponseEntity patchComment(@PathVariable("comment-id") @Positive long commentId,
                                       @Valid @RequestBody CommentDto.Patch requestBody){

        requestBody.setCommentId(commentId);

        Comment comment = mapper.commentPatchDtoToComment(requestBody);

        Comment response = commentService.updateComment(comment);


        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @GetMapping("/{comment-id}")
    public ResponseEntity getComment(@PathVariable("comment-id") @Positive long commentId){

        Comment response = commentService.findComment(commentId);

        return new ResponseEntity<>(mapper.commentToCommentResponseDto(response), HttpStatus.OK);
    }

    @DeleteMapping("/{comment-id}")
    public ResponseEntity deleteComment(@PathVariable("comment-id") @Positive long commentId){

        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
