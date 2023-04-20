package core.app.comment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    private Long commentId;
    private String comment;
    private Long memberId;
    private Long boardId;

    public Comment(Long commentId, String comment, Long memberId, Long boardId) {
        this.commentId = commentId;
        this.comment = comment;
        this.memberId = memberId;
        this.boardId = boardId;
    }
}
