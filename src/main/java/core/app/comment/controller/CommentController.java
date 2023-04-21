package core.app.comment.controller;


import core.app.comment.dto.CommentPatchDto;
import core.app.comment.dto.CommentPostDto;
import core.app.comment.entity.Comment;
import core.app.comment.mapper.CommentMapper;
import core.app.comment.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/commits")
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper mapper;

    public CommentController(CommentService commentService, CommentMapper mapper){
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postComment(@Valid @RequestBody CommentPostDto commentPostDto){

        Comment comment = mapper.commentPostDtoToComment(commentPostDto);

        Comment response = commentService.createComment(comment);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{comment-id}")
    public ResponseEntity patchComment(@PathVariable("/comment-id") @Positive Long commentId,
                                       @Valid @RequestBody CommentPatchDto commentPatchDto){

        commentPatchDto.setCommentId(commentId);

        Comment comment = mapper.commentPatchDtoToComment(commentPatchDto);

        Comment response = commentService.updateComment(comment);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{comment-id}")
    public ResponseEntity getComment(@PathVariable("/comment-id") @Positive Long commentId){

        Comment response = commentService.findComment(commentId);

        return new ResponseEntity<>(mapper.commentToCommentResponseDto(response), HttpStatus.OK);
    }

    @DeleteMapping("/{comment-id}")
    public ResponseEntity deleteComment(@PathVariable("/comment-id") @Positive Long commentId){

        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}