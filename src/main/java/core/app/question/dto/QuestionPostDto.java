package core.app.question.dto;


import core.app.validator.NotSpace;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
public class QuestionPostDto {
    @NotSpace
    private String title;
    @NotSpace
    private String body;
    private long memberId;
}
