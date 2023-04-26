package core.app.question.mapper;

import core.app.question.dto.QuestionPatchDto;
import core.app.question.dto.QuestionPostDto;
import core.app.question.dto.QuestionResponseDto;
import core.app.question.entity.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2023-04-26T13:23:25+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.18 (Azul Systems, Inc.)"
=======
    date = "2023-04-26T01:10:49+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
>>>>>>> d89187dd16726e2638b9e5ae8d2dc039d9a96b88
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionPostDtoToQuestion(QuestionPostDto questionPostDto) {
        if ( questionPostDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setTitle( questionPostDto.getTitle() );
        question.setBody( questionPostDto.getBody() );

        return question;
    }

    @Override
    public Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto) {
        if ( questionPatchDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( questionPatchDto.getQuestionId() );
        question.setTitle( questionPatchDto.getTitle() );
        question.setBody( questionPatchDto.getBody() );

        return question;
    }

    @Override
    public QuestionResponseDto questionToQuestionResponseDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionResponseDto.QuestionResponseDtoBuilder questionResponseDto = QuestionResponseDto.builder();

<<<<<<< HEAD
        if ( question.getQuestionId() != null ) {
            questionResponseDto.setQuestionId( question.getQuestionId() );
        }
        questionResponseDto.setTitle( question.getTitle() );
        questionResponseDto.setBody( question.getBody() );
        questionResponseDto.setModifiedAt( question.getModifiedAt() );
=======
        questionResponseDto.questionId( question.getQuestionId() );
        questionResponseDto.title( question.getTitle() );
        questionResponseDto.body( question.getBody() );
        questionResponseDto.modifiedAt( question.getModifiedAt() );
        questionResponseDto.createdAt( question.getCreatedAt() );
>>>>>>> d89187dd16726e2638b9e5ae8d2dc039d9a96b88

        return questionResponseDto.build();
    }

    @Override
    public List<QuestionResponseDto> questionToQuestionResponseDtos(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionResponseDto> list = new ArrayList<QuestionResponseDto>( questions.size() );
        for ( Question question : questions ) {
            list.add( questionToQuestionResponseDto( question ) );
        }

        return list;
    }
}
