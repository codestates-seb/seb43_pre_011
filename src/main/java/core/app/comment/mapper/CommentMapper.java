package core.app.comment.mapper;

import core.app.comment.dto.CommentPatchDto;
import core.app.comment.dto.CommentPostDto;
import core.app.comment.dto.CommentResponseDto;
import core.app.comment.entity.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment commentToCommentPostDto(CommentPostDto commentPostDto);
    Comment commentToCommentPatchDto(CommentPatchDto commentPatchDto);
    CommentResponseDto commentToCommentResponseDto(Comment comment);
//    List<CommentResponseDto> commentToCommentResponseDtos(List<Comment> comments);
}
