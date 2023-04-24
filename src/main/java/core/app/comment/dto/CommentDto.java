package core.app.comment.dto;

import core.app.validator.NotSpace;
import core.app.vote.entity.Vote;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class CommentDto {

    @Getter
    @AllArgsConstructor
    public static class Post{

        @NotSpace
        private String comment;

        @NotSpace
        private long memberId;

        @NotSpace
        private long boardId;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch{

        private long commentId;

        @NotSpace
        private String comment;

        @NotSpace
        private long memberId;

        @NotSpace
        private long boardId;

        public void setCommentId(long commentId){
            this.commentId = commentId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response{

        private long commentId;
        private String comment;
        private long memberId;
        private long boardId;
        private Vote vote;
    }
}
