package core.app.question.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class QuestionResponseDto {
    private Long questionId;
    private String title;
    private String body;
    @Getter private Long memberId;
    private LocalDateTime modifiedAt;
    private LocalDateTime createdAt;
}
