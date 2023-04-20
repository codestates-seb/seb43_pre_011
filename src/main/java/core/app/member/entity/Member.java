package core.app.member.entity;

import core.app.validator.NotSpace;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    private Long memberId;
    private String email;
    private String password;
    private String nickName;
    private int grade;

    public Member(Long memberId, String email, String password, String nickName, int grade) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.grade = grade;
    }
}
