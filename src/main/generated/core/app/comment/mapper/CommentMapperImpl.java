package core.app.comment.mapper;

import core.app.comment.dto.CommentPatchDto;
import core.app.comment.dto.CommentPostDto;
import core.app.comment.dto.CommentResponseDto;
import core.app.comment.entity.Comment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T08:51:52+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.18 (Azul Systems, Inc.)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment commentToCommentPostDto(CommentPostDto commentPostDto) {
        if ( commentPostDto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setComment( commentPostDto.getComment() );
        comment.setMemberId( commentPostDto.getMemberId() );
        comment.setBoardId( commentPostDto.getBoardId() );

        return comment;
    }

    @Override
    public Comment commentToCommentPatchDto(CommentPatchDto commentPatchDto) {
        if ( commentPatchDto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setCommentId( commentPatchDto.getCommentId() );
        comment.setComment( commentPatchDto.getComment() );
        comment.setMemberId( commentPatchDto.getMemberId() );
        comment.setBoardId( commentPatchDto.getBoardId() );

        return comment;
    }

    @Override
    public CommentResponseDto commentToCommentResponseDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentResponseDto commentResponseDto = new CommentResponseDto();

        commentResponseDto.setCommentId( comment.getCommentId() );
        commentResponseDto.setComment( comment.getComment() );
        commentResponseDto.setMemberId( comment.getMemberId() );
        commentResponseDto.setBoardId( comment.getBoardId() );

        return commentResponseDto;
    }
}
