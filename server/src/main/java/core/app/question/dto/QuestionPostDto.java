package core.app.question.dto;


import core.app.member.entity.Member;
import core.app.validator.NotSpace;
import lombok.*;

import javax.validation.constraints.Positive;


@Getter

public class QuestionPostDto {

    @Positive
    private long memberId;

    @NotSpace
    private String title;

    @NotSpace
    private String body;

    public Member getMember(){
        Member member = new Member();
        member.setMemberId(memberId);
        return member;
    }

}
