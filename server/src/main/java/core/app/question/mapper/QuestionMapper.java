package core.app.question.mapper;

import core.app.question.dto.QuestionPatchDto;
import core.app.question.dto.QuestionPostDto;
import core.app.question.dto.QuestionResponseDto;
import core.app.question.entity.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);
    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);
    QuestionResponseDto questionToQuestionResponseDto(Question question);
    List<QuestionResponseDto> questionToQuestionResponseDtos(List<Question> questions);

}
