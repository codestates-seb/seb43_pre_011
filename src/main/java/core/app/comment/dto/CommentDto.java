package core.app.comment.dto;

import core.app.validator.NotSpace;
import core.app.vote.entity.Vote;
import lombok.*;

import java.time.LocalDateTime;

public class CommentDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post{

        @NotSpace
        private String comment;

        private long memberId;

        private long questionId;

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Patch{

        private long commentId;

        @NotSpace
        private String comment;

        private long memberId;

        private long questionId;

        public void setCommentId(long commentId){
            this.commentId = commentId;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{

        private long commentId;
        private String comment;
        private long memberId;
        private long questionId;
        private Vote vote;
        private LocalDateTime createAt;
        private LocalDateTime modifiedAt;
    }
}
