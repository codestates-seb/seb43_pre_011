package core.app.vote.mapper;

import core.app.vote.dto.CommentVoteDto;
import core.app.vote.entity.CommentVote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentVoteMapper {
    @Mapping(source = "memberId", target = "member.memberId")
    @Mapping(source = "commentId", target = "comment.commentId")
    CommentVote commentVotePostDtoToCommentVote(CommentVoteDto.Post commentVotePostDto);

    @Mapping(source = "member.memberId", target = "memberId")
    CommentVoteDto.Response commentVoteToCommentVoteResponseDto(CommentVote commentVote);


}
