package core.app.like;

import core.app.audit.Auditable;
import core.app.question.entity.Question;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Like extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @Column(nullable = false)
    private int likeCount;

    @OneToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public void setMember(Question question){
        this.question = question;
        if(question.getLike() != this){
            question.setLike(this);
        }
    }
}
