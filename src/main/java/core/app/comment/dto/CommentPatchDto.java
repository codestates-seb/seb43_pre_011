package core.app.comment.dto;

import core.app.validator.NotSpace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPatchDto {

    private Long commentId;

    @NotSpace
    private String comment;

    @NotSpace
    private Long memberId;

    @NotSpace
    private Long boardId;
}
