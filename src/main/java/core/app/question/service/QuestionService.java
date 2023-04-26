package core.app.question.service;

import core.app.exception.BusinessLogicException;
import core.app.exception.ExceptionCode;
import core.app.question.entity.Question;
import core.app.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question){
        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question){
        Question findQuestion = findQuestion(question.getQuestionId());
        Optional.ofNullable(question.getComment())
                .ifPresent(findQuestion::setComment);
        Optional.ofNullable(question.getTitle())
                .ifPresent(findQuestion::setTitle);
        Optional.ofNullable(question.getBody())
                .ifPresent(findQuestion::setBody);

        return findQuestion;
    }
    public void deleteQuestion(long questionId){
        Question question = findQuestion(questionId);
        questionRepository.deleteById(questionId);
    }

    public Question findQuestion(long questionId){
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question findQuestion = optionalQuestion.orElseThrow(()->new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));

        return findQuestion;
    }

    public Page<Question> findQuestions(int page, int size){
        return questionRepository.findAll(PageRequest.of(page,size, Sort.by("questionId").descending()));
    }

}
