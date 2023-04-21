package core.app.board.dto;

import core.app.validator.NotSpace;
import lombok.Getter;

@Getter
public class BoardPatchDto {
    private Long boardId;

    @NotSpace
    private String title;

    public void setBoardId(Long boardId){
        this.boardId = boardId;
    }

}
