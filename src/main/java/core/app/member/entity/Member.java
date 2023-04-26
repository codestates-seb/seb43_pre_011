package core.app.member.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import core.app.audit.Auditable;
import core.app.comment.entity.Comment;
import core.app.vote.entity.Vote;
import core.app.question.entity.Question;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private int grade;

    // 한 명의 member가 여러 개의 질문 작성
    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<>();

    // 한 명의 member가 여러 개의 코멘트 작성
    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();

    // 한 명의 member가 여러 개의 좋아요
    @OneToMany(mappedBy = "member")
    private List<Vote> votes = new ArrayList<>();
}
