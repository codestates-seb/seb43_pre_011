package core.app.board.entity;

import core.app.audit.Auditable;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Board extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(length = 50)
    private String title;

    // 보드 상태
    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private BoardStatus boardStatus = BoardStatus.BOARD_ACTIVE;

    public enum BoardStatus{
        BOARD_ACTIVE("활성화"),
        BOARD_NOT_ACTIVE("비활성화");

        @Getter
        private String status;

        BoardStatus(String status){
            this.status = status;
        }
    }
}
