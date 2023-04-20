package core.app.member.entity;

import core.app.like.Like;
import core.app.validator.NotSpace;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {

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

    public Member(Long memberId, String email, String password, String nickName, int grade) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.grade = grade;
    }
}
