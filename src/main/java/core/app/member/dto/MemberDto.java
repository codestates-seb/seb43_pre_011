package core.app.member.dto;

import core.app.validator.NotSpace;
import core.app.vote.entity.Vote;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class Post{

        @NotSpace
        @Email
        private String email;

        @NotSpace
        private String password;

        @Pattern(regexp = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$",
                message = "2자 이상 16자 이하, 영어 또는 숫자 또는 한글로 구성")
        private String nickName;

        @Positive
        private int grade;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch{

        private long memberId;

        @NotSpace
        @Email
        private String email;

        @NotSpace
        private String password;

        @Pattern(regexp = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$",
                message = "2자 이상 16자 이하, 영어 또는 숫자 또는 한글로 구성")
        private String nickName;

        @Positive
        private int grade;

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
        private int grade;
    }
}
