package core.app.board.entity;

import core.app.question.entity.Question;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST)
    private List<Question> question = new ArrayList<>();

    public Board(Long boardId, String title, String body) {
        this.boardId = boardId;
        this.title = title;
        this.body = body;
    }

}
