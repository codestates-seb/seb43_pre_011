package core.app.vote.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

public class QuestionVoteDto {
    @Getter
    public static class Post {
        @Positive
        private Long memberId;

        @Positive
        private Long questionId;
    }

    @Getter
    @Setter
    public static class Response {
        private Long questionVoteId;

        private boolean questionVoteFlag;

        private Long memberId;
    }
}
