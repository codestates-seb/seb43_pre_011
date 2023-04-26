package core.app.question.dto;


import core.app.validator.NotSpace;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class QuestionPatchDto {
    private Long questionId;
    @NotSpace
    private String title;
    @NotSpace
    private String body;

    private Long memberId;

}
