package core.app.comment.mapper;

import core.app.comment.dto.CommentDto.Patch;
import core.app.comment.dto.CommentDto.Post;
import core.app.comment.dto.CommentDto.Response;
import core.app.comment.entity.Comment;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-27T00:50:38+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.18 (Azul Systems, Inc.)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment commentPostDtoToComment(Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setComment( requestBody.getComment() );
        comment.setQuestion( requestBody.getQuestion() );
        comment.setMember( requestBody.getMember() );

        return comment;
    }

    @Override
    public Comment commentPatchDtoToComment(Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setCommentId( requestBody.getCommentId() );
        comment.setComment( requestBody.getComment() );

        return comment;
    }

    @Override
    public Response commentToCommentResponseDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        Response response = new Response();

        response.setMember( comment.getMember() );
        response.setQuestion( comment.getQuestion() );
        response.setCommentId( comment.getCommentId() );
        response.setComment( comment.getComment() );
        response.setCommentVote( comment.getCommentVote() );
        response.setCreateAt( comment.getCreateAt() );
        response.setModifiedAt( comment.getModifiedAt() );

        return response;
    }

    @Override
    public List<Response> commentToCommentResponseDtos(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<Response> list = new ArrayList<Response>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( commentToCommentResponseDto( comment ) );
        }

        return list;
    }
}
