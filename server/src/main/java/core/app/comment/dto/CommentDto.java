package core.app.comment.dto;

import core.app.member.entity.Member;
import core.app.question.entity.Question;
import core.app.validator.NotSpace;
import core.app.vote.entity.CommentVote;
import lombok.*;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

public class CommentDto {

    @Getter
    public static class Post{

        @Positive
        private long memberId;

        @Positive
        private long questionId;

        @NotSpace
        private String comment;

        public Member getMember(){
            Member member = new Member();
            member.setMemberId(memberId);
            return member;
        }

        public Question getQuestion(){
            Question question = new Question();
            question.setQuestionId(questionId);
            return question;
        }
    }

    @Getter
    public static class Patch{

        private long commentId;

        @NotSpace
        private String comment;

        public void setCommentId(long commentId){
            this.commentId = commentId;
        }
    }

    @Getter
    @Setter
    public static class Response{

        private long commentId;

        @Setter(AccessLevel.NONE)
        private long memberId;

        @Setter(AccessLevel.NONE)
        private long questionId;

        private String comment;

        private CommentVote commentVote;

        private LocalDateTime createAt;

        private LocalDateTime modifiedAt;

        public void setMember(Member member){
            this.memberId = member.getMemberId();
        }
        public void setQuestion(Question question){
            this.questionId = question.getQuestionId();
        }
    }
}
