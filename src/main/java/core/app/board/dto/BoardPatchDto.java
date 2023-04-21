package core.app.board.dto;

import core.app.validator.NotSpace;

public class BoardPatchDto {

    private Long boardId;

    @NotSpace
    private String title;

    @NotSpace
    private String body;

    public BoardPatchDto(Long boardId, String title, String body) {
        this.boardId = boardId;
        this.title = title;
        this.body = body;
    }
}
