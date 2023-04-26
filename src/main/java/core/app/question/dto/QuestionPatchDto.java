package core.app.question.dto;


import core.app.validator.NotSpace;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionPatchDto {
    private long questionId;
    @NotSpace
    private String title;
    @NotSpace
    private String body;

    private long memberId;

    private LocalDateTime modifiedAt;

}
