package core.app.question.dto;


import core.app.member.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class QuestionResponseDto {

    private long questionId;

    @Setter(AccessLevel.NONE)
    private long memberId;

    private String title;
    private String body;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public void setMember(Member member){
        this.memberId = member.getMemberId();
    }

}
