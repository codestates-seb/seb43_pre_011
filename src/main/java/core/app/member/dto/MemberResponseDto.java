package core.app.member.dto;

import core.app.validator.NotSpace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MemberResponseDto {
    private Long memberId;
    private String email;
    private String password;
    private String nickName;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
}
