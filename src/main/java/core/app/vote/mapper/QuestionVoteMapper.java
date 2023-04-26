package core.app.vote.mapper;

import core.app.vote.dto.QuestionVoteDto;
import core.app.vote.entity.QuestionVote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionVoteMapper {
    @Mapping(source = "memberId", target = "member.memberId")
    @Mapping(source = "questionId", target = "question.questionId")
    QuestionVote questionVotePostDtoToQuestionVote(QuestionVoteDto.Post questionVotePostDto);

    @Mapping(source = "member.memberId", target = "memberId")
    QuestionVoteDto.Response questionVoteToQuestionVoteResponseDto(QuestionVote questionVote);
}
