


package core.app.comment.mapper;

import core.app.comment.dto.CommentDto;
import core.app.comment.entity.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment commentPostDtoToComment(CommentDto.Post requestBody);
    Comment commentPatchDtoToComment(CommentDto.Patch requestBody);
    CommentDto.Response commentToCommentResponseDto(Comment comment);
    List<CommentDto.Response> commentToCommentResponseDtos(List<Comment> comments);
}