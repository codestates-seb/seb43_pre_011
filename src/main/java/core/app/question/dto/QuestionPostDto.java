package core.app.question.dto;


import core.app.validator.NotSpace;
import lombok.*;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionPostDto {
    private Long questionId;
    @NotSpace
    private String title;
    @NotSpace
    private String body;

    private Long memberId;
    @Positive
    private Long like;

    private LocalDateTime createdAt;
}
