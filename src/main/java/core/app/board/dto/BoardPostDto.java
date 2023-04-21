package core.app.board.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class BoardPostDto {

    @NotBlank
    private String title;

}
