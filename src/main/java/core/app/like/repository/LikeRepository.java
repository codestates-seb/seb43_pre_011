package core.app.like.repository;

import core.app.like.entity.Like;
import core.app.member.entity.Member;
import core.app.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByMemberAndQuestion(Member user, Question post);
    long countByQuestion(Question question);//해당 질문글에 대한 좋아요 개수 반환.
}
