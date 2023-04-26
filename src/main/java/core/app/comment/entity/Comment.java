package core.app.comment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import core.app.audit.Auditable;
import core.app.member.entity.Member;
import core.app.question.entity.Question;
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
    @JsonBackReference
    private Question question;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @JsonBackReference
    private Member member;

}
