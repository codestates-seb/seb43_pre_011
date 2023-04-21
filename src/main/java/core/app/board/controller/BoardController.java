package core.app.board.controller;

import core.app.board.dto.BoardPatchDto;
import core.app.board.dto.BoardPostDto;
import core.app.board.entity.Board;
import core.app.board.mapper.BoardMapper;
import core.app.board.service.BoardService;
import core.app.dto.MultiResponseDto;
import core.app.dto.SingleResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Valid
@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController {

    private final static String BORDER_DEFAULT_URL = "/boards";
    private final BoardService boardService;
    private final BoardMapper mapper;

    public BoardController(BoardService boardService, BoardMapper mapper) {
        this.boardService = boardService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postBoard(@Valid @RequestBody BoardPostDto boardPostDto){

        Board board = mapper.boardPostDtoToBoard(boardPostDto);

        Board createBoard = boardService.createBoard(board);

        return new ResponseEntity(new SingleResponseDto<>(mapper.boardToBoardResponseDto(createBoard)), HttpStatus.CREATED);
    }

    @PatchMapping("/{board-id}")
    public ResponseEntity patchBaord(@PathVariable("board-id") Long boardId,
                                     @Valid @RequestBody BoardPatchDto boardPatchDto){
        boardPatchDto.setBoardId(boardId);

        Board board = boardService.updateBoard(mapper.boardPatchDtoToBoard(boardPatchDto));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.boardToBoardResponseDto(board)), HttpStatus.OK);
    }

    @GetMapping("/{board-id}")
    public ResponseEntity getBoard(@PathVariable("{board-id}") @Positive Long boardId){

        Board board = boardService.findBoard(boardId);

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.boardToBoardResponseDto(board)),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getBoards(@Positive @RequestParam int page,
                                    @Positive @RequestParam int size){

        Page<Board> pageBoards = boardService.findBoards(page - 1, size);
        List<Board> boards = pageBoards.getContent();

        return new ResponseEntity<>(new MultiResponseDto<>(mapper.boardToBoardResponseDtos(boards), pageBoards), HttpStatus.OK);
    }

    @DeleteMapping("/{board-id}")
    public ResponseEntity deleteBoard(@PathVariable("board-id") @Positive Long boardId){

        boardService.deleteBoard(boardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
