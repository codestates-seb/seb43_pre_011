package core.app.question.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import core.app.like.Like;
import core.app.member.entity.Member;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Question {
    @Id
    private Long questionId; //질문 번호
    private String title; //질문 제목
    private String body; //질문 본문
    private Long memberId; //질문자 번호
    @LastModifiedDate
    private LocalDateTime modifiedAt; //수정 시간
    @CreatedDate
    private LocalDateTime createdAt; //만들어진 시간

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonBackReference
    private Member member;
    private String comment;

    @OneToOne(mappedBy = "question", cascade = CascadeType.PERSIST)
    private Like like;

    public void setLike(Like like){
        this.like = like;
        if(like.getQuestion() != this){
            like.setQuestion(this);
        }
    }
}
