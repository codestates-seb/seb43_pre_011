package core.app.member.dto;

import core.app.validator.NotSpace;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class MemberPostDto {

    @Email
    private String email;


    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9!@#$%^&*()._-]{8,16}$",
             message = "8자 이상 16자 이하, 영어와 숫자의 조합으로 구성")
    private String password;



    @Pattern(regexp = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$",
             message = "2자 이상 16자 이하, 영어 또는 숫자 또는 한글로 구성")
    private String nickName;


    @Positive
    private int grade;

    public MemberPostDto(String email, String password, String nickName, int grade) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.grade = grade;
    }
}
