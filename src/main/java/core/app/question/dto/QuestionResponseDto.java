package core.app.question.dto;

import core.app.validator.NotSpace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionResponseDto {
    private Long questionId;
    private String title;
    private String body;
    private Long memberId;
    private LocalDateTime modifiedAt;
    private Long like;
    private LocalDateTime createdAt;
}
