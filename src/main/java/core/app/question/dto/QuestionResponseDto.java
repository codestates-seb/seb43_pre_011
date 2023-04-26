package core.app.question.dto;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class QuestionResponseDto {
    private long questionId;
    private String title;
    private String body;

    private long memberId;


}
