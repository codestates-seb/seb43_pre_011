package core.app.vote.repository;

import core.app.vote.entity.QuestionVote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionVoteRepository extends JpaRepository<QuestionVote, Long> {
    Optional<QuestionVote> findByMemberAndQuestion(Long questionId, Long memberId);
}
