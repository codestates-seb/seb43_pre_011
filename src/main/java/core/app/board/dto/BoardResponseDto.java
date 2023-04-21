package core.app.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardResponseDto {
    private Long boardId;
    private String title;
    private String body;
}
