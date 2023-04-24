package core.app.vote.repository;

import core.app.vote.entity.Vote;
import core.app.member.entity.Member;
import core.app.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findByMemberAndQuestion(Member user, Question post);
    long countByQuestion(Question question);//해당 질문글에 대한 좋아요 개수 반환.
}
