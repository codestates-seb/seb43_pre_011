package core.app.board.dto;

import core.app.validator.NotSpace;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardPostDto {

    @NotSpace
    private String title;

    @NotSpace
    private String body;

    public BoardPostDto(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
