package core.app.member.dto;

import core.app.validator.NotSpace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberResponseDto {
    private Long memberId;
    private String email;
    private String password;
    private String nickName;
    private int grade;
}
