package core.app.board.repository;

import core.app.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findByBoardTitle(String title);

    @Query(value = "SELECT c FROM Board c where c.boardId = :boardId")
    Optional<Board> findByBoard(Long boardId);
}
