package core.app.question.dto;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionPatchDto {
    private Long questionId;

    private String title;

    private String body;

    private Long memberId;

    private LocalDateTime modifiedAt;
}
