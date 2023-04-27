package core.app.comment.controller;


import core.app.comment.dto.CommentDto;
import core.app.comment.entity.Comment;
import core.app.comment.mapper.CommentMapper;
import core.app.comment.service.CommentService;
import core.app.dto.SingleResponseDto;
import core.app.member.entity.Member;
import core.app.member.service.MemberService;
import core.app.question.entity.Question;
import core.app.question.service.QuestionService;
import core.app.utils.UriCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*", allowCredentials = "true")
@Validated
@RestController
@RequestMapping("/comments") // /question/{question-id}/comments
public class CommentController {

    private final static String COMMENT_DEFAULT_URL = "/comments";
    private final CommentService commentService;
    private final CommentMapper mapper;
    private final MemberService memberService;
    private final QuestionService questionService;

    public CommentController(CommentService commentService, CommentMapper mapper, MemberService memberService, QuestionService questionService) {
        this.commentService = commentService;
        this.mapper = mapper;
        this.memberService = memberService;
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity postComment(@Valid @RequestBody CommentDto.Post requestBody){

        Comment comment = commentService.createComment(mapper.commentPostDtoToComment(requestBody));

        URI location = UriCreator.createUri(COMMENT_DEFAULT_URL, comment.getCommentId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{comment-id}")
    public ResponseEntity patchComment(@PathVariable("comment-id") @Positive long commentId,
                                       @Valid @RequestBody CommentDto.Patch requestBody){

        requestBody.setCommentId(commentId);

        Comment comment = commentService.updateComment(mapper.commentPatchDtoToComment(requestBody));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.commentToCommentResponseDto(comment)), HttpStatus.OK);
    }

    @GetMapping("/{comment-id}")
    public ResponseEntity getComment(@PathVariable("comment-id") @Positive long commentId){

        Comment response = commentService.findComment(commentId);

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.commentToCommentResponseDto(response)), HttpStatus.OK);
    }

    @DeleteMapping("/{comment-id}")
    public ResponseEntity deleteComment(@PathVariable("comment-id") @Positive long commentId){

        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
