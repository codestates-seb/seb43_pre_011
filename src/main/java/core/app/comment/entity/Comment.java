package core.app.comment.entity;

import core.app.member.entity.Member;
import core.app.question.entity.Question;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    private String content;

    // 질문 게시글과 다:1 매핑
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


    public Comment(Long commentId, String content, Question question) {
        this.commentId = commentId;
        this.content = content;
        this.question = question;

    }
}
