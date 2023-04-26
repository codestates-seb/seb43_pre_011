package core.app.vote.mapper;

import core.app.member.entity.Member;
import core.app.question.entity.Question;
import core.app.vote.dto.QuestionVoteDto.Post;
import core.app.vote.dto.QuestionVoteDto.Response;
import core.app.vote.entity.QuestionVote;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-26T23:23:18+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class QuestionVoteMapperImpl implements QuestionVoteMapper {

    @Override
    public QuestionVote questionVotePostDtoToQuestionVote(Post questionVotePostDto) {
        if ( questionVotePostDto == null ) {
            return null;
        }

        QuestionVote questionVote = new QuestionVote();

        questionVote.setMember( postToMember( questionVotePostDto ) );
        questionVote.setQuestion( postToQuestion( questionVotePostDto ) );

        return questionVote;
    }

    @Override
    public Response questionVoteToQuestionVoteResponseDto(QuestionVote questionVote) {
        if ( questionVote == null ) {
            return null;
        }

        Response response = new Response();

        response.setMemberId( questionVoteMemberMemberId( questionVote ) );
        response.setQuestionVoteId( questionVote.getQuestionVoteId() );
        response.setQuestionVoteFlag( questionVote.isQuestionVoteFlag() );

        return response;
    }

    protected Member postToMember(Post post) {
        if ( post == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberId( post.getMemberId() );

        return member;
    }

    protected Question postToQuestion(Post post) {
        if ( post == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( post.getQuestionId() );

        return question;
    }

    private Long questionVoteMemberMemberId(QuestionVote questionVote) {
        if ( questionVote == null ) {
            return null;
        }
        Member member = questionVote.getMember();
        if ( member == null ) {
            return null;
        }
        Long memberId = member.getMemberId();
        if ( memberId == null ) {
            return null;
        }
        return memberId;
    }
}
