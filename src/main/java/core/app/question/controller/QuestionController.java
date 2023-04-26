package core.app.question.controller;

import core.app.dto.MultiResponseDto;
import core.app.dto.SingleResponseDto;
import core.app.member.service.MemberService;
import core.app.member.entity.Member;
import core.app.question.dto.QuestionPatchDto;
import core.app.question.dto.QuestionPostDto;
import core.app.question.dto.QuestionResponseDto;
import core.app.question.entity.Question;
import core.app.question.mapper.QuestionMapper;
import core.app.question.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/questions")
@Validated
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionMapper questionMapper;
    private final MemberService memberService;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper, MemberService memberService) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionPostDto questionPostDto){
        Question question = questionMapper.questionPostDtoToQuestion(questionPostDto);
        Member member = memberService.findMember(questionPostDto.getMemberId());

        question.setMember(member);
        Question responseContent = questionService.createQuestion(question);
        QuestionResponseDto response = questionMapper.questionToQuestionResponseDto(responseContent);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{question-id}") //질문 수정
    public ResponseEntity patchQuestion(@PathVariable("question-id") long questionId,
                                        @Valid @RequestBody QuestionPatchDto questionPatchDto){
        questionPatchDto.setQuestionId(questionId);
        Question question = questionService.updateQuestion(questionMapper.questionPatchDtoToQuestion(questionPatchDto));

        return new ResponseEntity<>(new SingleResponseDto<>(questionMapper.questionToQuestionResponseDto(question)),HttpStatus.OK);


    }
    @GetMapping("/{question-id}") //질문 조회
    public ResponseEntity getQuestion(@PathVariable("question-id") long questionId){
        Question question = questionService.findQuestion(questionId);

        return new ResponseEntity<>(new SingleResponseDto<>(questionMapper.questionToQuestionResponseDto(question)),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getQuestions(@RequestParam int page, @RequestParam int size){

        Page<Question> pageQuestions = questionService.findQuestions(page-1,size);

        List<Question> questions = pageQuestions.getContent();

        return new ResponseEntity<>(new MultiResponseDto<>(questionMapper.questionToQuestionResponseDtos(questions),pageQuestions),HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}") //질문 삭제
    public ResponseEntity deleteQuestion(@PathVariable("question-id") long questionId){
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
