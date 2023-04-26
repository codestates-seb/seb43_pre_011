package core.app.question.dto;


import core.app.validator.NotSpace;
import lombok.*;



@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionPostDto {

    @NotSpace
    private String title;
    @NotSpace
    private String body;

    private long memberId;
}
