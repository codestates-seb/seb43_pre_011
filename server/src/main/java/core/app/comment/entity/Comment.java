package core.app.comment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import core.app.audit.Auditable;
import core.app.member.entity.Member;
import core.app.question.entity.Question;
import core.app.vote.entity.CommentVote;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    private String comment;

    // 질문 게시글과 다:1 매핑
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne(mappedBy = "comment")
    private CommentVote commentVote;

}
