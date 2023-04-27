package core.app.vote.service;

import core.app.comment.service.CommentService;
import core.app.member.service.MemberService;
import core.app.vote.entity.CommentVote;
import core.app.vote.repository.CommentVoteRepository;
import core.app.member.entity.Member;
import core.app.member.repository.MemberRepository;
import core.app.question.entity.Question;
import core.app.question.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommentVoteService {
    private CommentVoteRepository commentVoteRepository;
    private MemberService memberService;
    private CommentService commentService;

    public CommentVoteService(CommentVoteRepository commentVoteRepository, MemberService memberService, CommentService commentService) {
        this.commentVoteRepository = commentVoteRepository;
        this.memberService = memberService;
        this.commentService = commentService;
    }

    public CommentVote createCommentVote(CommentVote commentVote){
        memberService.findMember(commentVote.getMember().getMemberId());
        commentService.findComment(commentVote.getComment().getCommentId());

        Optional<CommentVote> optionalCommentVote = Optional.ofNullable(verifyExistCommentVote(commentVote));
        CommentVote vote = optionalCommentVote.orElse(commentVote);

        vote.setCommentVoteFlag(!vote.isCommentVoteFlag());
        return commentVoteRepository.save(vote);
    }

    private CommentVote verifyExistCommentVote(CommentVote commentVote){
        Optional<CommentVote> optionalCommentVote = commentVoteRepository.findByMemberAndComment(commentVote.getComment().getCommentId(), commentVote.getMember().getMemberId());
        return optionalCommentVote.orElse(null);
    }

}
