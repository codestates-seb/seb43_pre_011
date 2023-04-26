package core.app.member.dto;

import core.app.audit.Auditable;
import core.app.validator.NotSpace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

public class MemberDto{
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post{

        @NotSpace
        @Email
        private String email;

        @NotSpace
        private String password;

        @Pattern(regexp = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$",
                message = "2자 이상 16자 이하, 영어 또는 숫자 또는 한글로 구성")
        @NotSpace
        private String nickName;

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Patch {

        private long memberId;


        @Email
        @NotSpace
        private String email;

        @NotSpace
        private String password;

        @Pattern(regexp = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$",
                message = "2자 이상 16자 이하, 영어 또는 숫자 또는 한글로 구성")
        @NotSpace
        private String nickName;

        public void setMemberId(long memberId){
            this.memberId = memberId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response{
        private long memberId;
        private String email;
        private String password;
        private String nickName;
        private LocalDateTime createAt;
        private LocalDateTime modifiedAt;
    }
}
