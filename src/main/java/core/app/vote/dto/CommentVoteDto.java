package core.app.vote.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;


public class CommentVoteDto {
    @Getter
    public static class Post{
        @Positive
        private long memberId;
        @Positive
        private long commentId;
    }

    @Getter
    @Setter
    public static class Response{
        private long commentVoteId;
        private boolean commentVoteFlag;
        private long memberId;
    }
}
