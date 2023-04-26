package core.app.vote.mapper;

import core.app.comment.entity.Comment;
import core.app.member.entity.Member;
import core.app.vote.dto.CommentVoteDto.Post;
import core.app.vote.dto.CommentVoteDto.Response;
import core.app.vote.entity.CommentVote;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-26T18:06:08+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.18 (Azul Systems, Inc.)"
)
@Component
public class CommentVoteMapperImpl implements CommentVoteMapper {

    @Override
    public CommentVote commentVotePostDtoToCommentVote(Post commentVotePostDto) {
        if ( commentVotePostDto == null ) {
            return null;
        }

        CommentVote commentVote = new CommentVote();

        commentVote.setMember( postToMember( commentVotePostDto ) );
        commentVote.setComment( postToComment( commentVotePostDto ) );

        return commentVote;
    }

    @Override
    public Response commentVoteToCommentVoteResponseDto(CommentVote commentVote) {
        if ( commentVote == null ) {
            return null;
        }

        Response response = new Response();

        Long memberId = commentVoteMemberMemberId( commentVote );
        if ( memberId != null ) {
            response.setMemberId( memberId );
        }
        response.setCommentVoteId( commentVote.getCommentVoteId() );
        response.setCommentVoteFlag( commentVote.isCommentVoteFlag() );

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

    protected Comment postToComment(Post post) {
        if ( post == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setCommentId( post.getCommentId() );

        return comment;
    }

    private Long commentVoteMemberMemberId(CommentVote commentVote) {
        if ( commentVote == null ) {
            return null;
        }
        Member member = commentVote.getMember();
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
