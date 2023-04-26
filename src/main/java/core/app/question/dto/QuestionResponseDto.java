package core.app.question.dto;

import core.app.validator.NotSpace;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDto {
    private long questionId;
    private String title;
    private String body;
    private long memberId;

}
