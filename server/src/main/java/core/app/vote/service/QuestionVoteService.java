package core.app.vote.service;

import core.app.member.service.MemberService;
import core.app.question.service.QuestionService;
import core.app.vote.entity.QuestionVote;
import core.app.vote.repository.QuestionVoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionVoteService {
    private final QuestionVoteRepository questionVoteRepository;
    private final MemberService memberService;
    private final QuestionService questionService;

    public QuestionVoteService(QuestionVoteRepository questionVoteRepository, MemberService memberService, QuestionService questionService) {
        this.questionVoteRepository = questionVoteRepository;
        this.memberService = memberService;
        this.questionService = questionService;
    }

    public QuestionVote createQuestionVote(QuestionVote questionVote) {
        memberService.findMember(questionVote.getMember().getMemberId());
        questionService.findQuestion(questionVote.getQuestion().getQuestionId());

        Optional<QuestionVote> optionalQuestionVote = Optional.ofNullable(verifyExistQuestionVote(questionVote));
        QuestionVote vote = optionalQuestionVote.orElse(questionVote);

        vote.setQuestionVoteFlag(!vote.isQuestionVoteFlag());
        return questionVoteRepository.save(vote);
    }

    private QuestionVote verifyExistQuestionVote(QuestionVote questionVote) {
        Optional<QuestionVote> optionalQuestionVote =
                questionVoteRepository.findByMemberAndQuestion(questionVote.getQuestion().getQuestionId(), questionVote.getMember().getMemberId());
        return optionalQuestionVote.orElse(null);
    }


    public QuestionVote findByMemberIdQuestionVote(Long questionId,Long memberId) {
        Optional<QuestionVote> optionalQuestionBookmark = questionVoteRepository.findByMemberAndQuestion(questionId,memberId);
        QuestionVote findBookmark =
                optionalQuestionBookmark.orElse(new QuestionVote());

        return findBookmark;
    }
}
