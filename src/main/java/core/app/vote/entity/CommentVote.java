package core.app.vote.entity;

import core.app.audit.Auditable;
import core.app.comment.entity.Comment;
import core.app.member.entity.Member;
import core.app.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CommentVote{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentVoteId;

    private boolean commentVoteFlag = false;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne
    @JoinColumn(name ="comment_id")
    private Comment comment;
}
