package core.app.question.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import core.app.audit.Auditable;
import core.app.comment.entity.Comment;
import core.app.vote.entity.Vote;
import core.app.member.entity.Member;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity

@Getter
@Setter

public class Question extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId; //질문 번호
    private String title; //질문 제목
    private String body; //질문 본문


    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @JsonBackReference
    private Member member;

    @OneToMany(mappedBy = "question")
    private List<Comment> comment = new ArrayList();

    @OneToMany(mappedBy = "question")
    private List<Vote> votes = new ArrayList<>();
}
