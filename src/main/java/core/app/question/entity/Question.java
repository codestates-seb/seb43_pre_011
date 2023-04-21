package core.app.question.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import core.app.like.entity.Like;
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
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public class Question {
    @Id
    private Long questionId; //질문 번호
    private String title; //질문 제목
    private String body; //질문 본문
    @LastModifiedDate
    private LocalDateTime modifiedAt; //수정 시간
    @CreatedDate
    private LocalDateTime createdAt; //만들어진 시간

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonBackReference
    private Member member;
    private String comment;

    @OneToMany(mappedBy = "question")
    private List<Like> likes = new ArrayList<>();

}
