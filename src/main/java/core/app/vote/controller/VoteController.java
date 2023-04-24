package core.app.vote.controller;

import core.app.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @PostMapping//HTTP POST 요처으로 사용자 id와 질문 id를 전송하면 질문글에 대한 좋아요 정보를 vote 모델 클래스에 저장함.
    public void postVote(@RequestParam Long memberId,
                         @RequestParam Long questionId){
        voteService.postVote(memberId,questionId);
    }

    @DeleteMapping//HTTP DELETE 요청으로 사용자 id와 질문 id를 전송하면 질문글에 대한 좋아요 정보를 vote 모델 클래스에서 삭제함.
    public void postUnVote(@RequestParam Long memberId,
                           @RequestParam Long questionId){
        voteService.postUnVote(memberId,questionId);
    }

    @GetMapping("/{questionId}/votes/count") //GET 요청으로 여기 경로에다가 요청 보내면 해당 질문글에 대한 좋아요 개수 반환.
    public long getVoteCountByQuestionId(@PathVariable Long questionId){
        return voteService.getVoteCountByQuestionId(questionId);
    }


}
