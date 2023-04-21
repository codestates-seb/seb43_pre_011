package core.app.board.service;

import core.app.board.entity.Board;
import core.app.board.mapper.BoardMapper;
import core.app.board.repository.BoardRepository;
import core.app.exception.BusinessLogicException;
import core.app.exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardService {
    private final BoardRepository boardRepository;


    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board createBoard(Board board){
        String title = board.getTitle().toUpperCase();

        verifyExistBoard(title);
        board.setTitle(title);

        return boardRepository.save(board);
    }

    public Board updateBoard(Board board){

        Board findBoard = findVerifiedBoard(board.getBoardId());

        Optional.ofNullable(board.getTitle()).ifPresent(title ->findBoard.setTitle(title));

        throw new BusinessLogicException(ExceptionCode.BOARD_NOT_FOUND);
    }

    public Board findBoard(Long boardId){
        return findVerifiedBoardByQuery(boardId);
    }

    public Page<Board> findBoards(int page, int size){
        return boardRepository.findAll(PageRequest.of(page, size, Sort.by("boardId").descending()));
    }

    public void deleteBoard(Long boardId){
        Board board = findVerifiedBoard(boardId);
        boardRepository.delete(board);
    }

    public Board findVerifiedBoard(Long boardId){
        Optional<Board> optionalBoard = boardRepository.findByBoard(boardId);

        Board findBoard = optionalBoard.orElseThrow(() -> new BusinessLogicException(ExceptionCode.BOARD_NOT_FOUND));

        return findBoard;
    }

    private void verifyExistBoard(String title){
        Optional<Board> board = boardRepository.findByBoardTitle(title);
        if(board.isPresent())
            throw new BusinessLogicException(ExceptionCode.BOARD_EXISTS);
    }

    private Board findVerifiedBoardByQuery(Long boardId){
        Optional<Board> optionalBoard = boardRepository.findByBoard(boardId);

        Board findBoard = optionalBoard.orElseThrow(() -> new BusinessLogicException(ExceptionCode.BOARD_NOT_FOUND));

        return findBoard;
    }
}
