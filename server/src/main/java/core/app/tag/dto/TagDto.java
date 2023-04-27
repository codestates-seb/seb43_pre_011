package core.app.tag.dto;

import core.app.comment.entity.Comment;
import core.app.question.entity.Question;
import core.app.validator.NotSpace;

public class TagDto {
    public static class Post{

        private long questionId;
        private long commentId;

        @NotSpace
        private long name;

        public Question getQeustion(){
            Question question = new Question();
            question.setQuestionId(questionId);
            return question;
        }

        public Comment getComment(){
            Comment comment = new Comment();
            comment.setCommentId(commentId);
            return comment;
        }
    }

    public static class Patch{

        private long tagId;
    }
}
