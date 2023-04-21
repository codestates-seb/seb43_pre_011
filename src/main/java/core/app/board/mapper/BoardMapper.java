package core.app.board.mapper;

import core.app.board.dto.BoardPatchDto;
import core.app.board.dto.BoardPostDto;
import core.app.board.dto.BoardResponseDto;
import core.app.board.entity.Board;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    Board boardPostDtoToBoard(BoardPostDto boardPostDto);
    Board boardPatchDtoToBoard(BoardPatchDto boardPatchDto);
    BoardResponseDto boardToBoardResponseDto(Board board);
    List<BoardResponseDto> boardToBoardResponseDtos(List<Board> boards);
}
