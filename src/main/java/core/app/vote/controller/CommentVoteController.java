package core.app.vote.controller;

import core.app.vote.dto.CommentVoteDto;
import core.app.vote.entity.CommentVote;
import core.app.vote.mapper.CommentVoteMapper;
import core.app.vote.service.CommentVoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/votes/comments")
@Valid
@RequiredArgsConstructor
public class CommentVoteController {
    private final CommentVoteService commentVoteService;
    private final CommentVoteMapper mapper;

    @PostMapping
    public ResponseEntity postCommentVote(@Valid @RequestBody CommentVoteDto.Post requestBody){
        CommentVote commentVote = commentVoteService.createCommentVote(mapper.commentVotePostDtoToCommentVote(requestBody));

        return ResponseEntity.ok(mapper.commentVoteToCommentVoteResponseDto(commentVote));
    }
}
