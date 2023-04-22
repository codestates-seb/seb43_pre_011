package core.app.vote.service;

import core.app.vote.entity.Vote;
import core.app.vote.repository.VoteRepository;
import core.app.member.entity.Member;
import core.app.member.repository.MemberRepository;
import core.app.question.entity.Question;
import core.app.question.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class VoteService {
    private VoteRepository voteRepository;
    private MemberRepository memberRepository;
    private QuestionRepository questionRepository;
    public VoteService(VoteRepository voteRepository, MemberRepository memberRepository, QuestionRepository questionRepository) {
        this.voteRepository = voteRepository;
        this.memberRepository = memberRepository;
        this.questionRepository = questionRepository;
    }

    @Transactional
    public void postVote(Long memberId, Long questionId){
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Question> question = questionRepository.findById(questionId);

        if(!member.isPresent() || !question.isPresent()){
            throw new RuntimeException("member or question not found");
        }
        Optional<Vote> existingVote = voteRepository.findByMemberAndQuestion(member.get(), question.get());

        if (!existingVote.isPresent()) {
            Vote vote = new Vote();
            vote.setMember(member.get());
            vote.setQuestion(question.get());
            voteRepository.save(vote);
        }
    }
    @Transactional
    public void postUnVote(Long memberId, Long questionId){
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Question> question = questionRepository.findById(questionId);

        if(!member.isPresent() || !question.isPresent()){
            throw new RuntimeException("member or question not found");
        }

        Optional<Vote> existingVote = voteRepository.findByMemberAndQuestion(member.get(),question.get());

        if (existingVote.isPresent()) {
            voteRepository.delete(existingVote.get());
        }
    }

    public long getVoteCountByQuestionId(Long questionId){
        Optional<Question> question = questionRepository.findById(questionId);
        if(!question.isPresent()){
            throw new RuntimeException("Question not found");
        }

        return voteRepository.countByQuestion(question.get());
    }
}
