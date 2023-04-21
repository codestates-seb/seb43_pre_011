package core.app.like.service;

import core.app.exception.BusinessLogicException;
import core.app.exception.ExceptionCode;
import core.app.like.entity.Like;
import core.app.like.repository.LikeRepository;
import core.app.member.entity.Member;
import core.app.member.repository.MemberRepository;
import core.app.question.entity.Question;
import core.app.question.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LikeService {
    private LikeRepository likeRepository;
    private MemberRepository memberRepository;
    private QuestionRepository questionRepository;
    public LikeService(LikeRepository likeRepository, MemberRepository memberRepository, QuestionRepository questionRepository) {
        this.likeRepository = likeRepository;
        this.memberRepository = memberRepository;
        this.questionRepository = questionRepository;
    }

    @Transactional
    public void likePost(Long memberId, Long questionId){
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Question> question = questionRepository.findById(questionId);

        if(!member.isPresent() || !question.isPresent()){
            throw new RuntimeException("member or question not found");
        }
        Optional<Like> existingLike = likeRepository.findByMemberAndQuestion(member.get(), question.get());

        if (!existingLike.isPresent()) {
            Like like = new Like();
            like.setMember(member.get());
            like.setQuestion(question.get());
            likeRepository.save(like);
        }
    }
    @Transactional
    public void unlikePost(Long memberId, Long questionId){
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Question> question = questionRepository.findById(questionId);

        if(!member.isPresent() || !question.isPresent()){
            throw new RuntimeException("member or question not found");
        }

        Optional<Like> existingLike = likeRepository.findByMemberAndQuestion(member.get(),question.get());

        if (existingLike.isPresent()) {
            likeRepository.delete(existingLike.get());
        }
    }

    public long getLikeCountByQuestionId(Long questionId){
        Optional<Question> question = questionRepository.findById(questionId);
        if(!question.isPresent()){
            throw new RuntimeException("Question not found");
        }

        return likeRepository.countByQuestion(question.get());
    }
}
