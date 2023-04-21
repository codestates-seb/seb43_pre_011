package core.app.comment.dto;

import core.app.validator.NotSpace;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class CommentPostDto {

    @NotSpace
    private String comment;

    @NotSpace
    private Long memberId;

    @NotSpace
    private Long boardId;

    public CommentPostDto(String comment, Long memberId, Long boardId) {
        this.comment = comment;
        this.memberId = memberId;
        this.boardId = boardId;
    }
}
