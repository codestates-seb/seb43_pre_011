package core.app.vote.controller;

import core.app.vote.dto.QuestionVoteDto;
import core.app.vote.entity.QuestionVote;
import core.app.vote.mapper.QuestionVoteMapper;
import core.app.vote.service.QuestionVoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/votes/questions")
@Valid
@RequiredArgsConstructor
public class QuestionVoteController {
    private final QuestionVoteService questionVoteService;
    private final QuestionVoteMapper mapper;

    @PostMapping
    public ResponseEntity postQuestionVote(@Valid @RequestBody QuestionVoteDto.Post requestBody){
        QuestionVote questionVote = questionVoteService.createQuestionVote(mapper.questionVotePostDtoToQuestionVote(requestBody));

        return ResponseEntity.ok(mapper.questionVoteToQuestionVoteResponseDto(questionVote));
    }
}
