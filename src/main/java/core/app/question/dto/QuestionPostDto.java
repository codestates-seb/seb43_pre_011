package core.app.question.dto;


import core.app.validator.NotSpace;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
public class QuestionPostDto {
<<<<<<< HEAD

=======
>>>>>>> d89187dd16726e2638b9e5ae8d2dc039d9a96b88
    @NotSpace
    private String title;
    @NotSpace
    private String body;
<<<<<<< HEAD

=======
>>>>>>> d89187dd16726e2638b9e5ae8d2dc039d9a96b88
    private long memberId;
}
