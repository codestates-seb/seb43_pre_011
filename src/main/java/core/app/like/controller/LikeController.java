package core.app.like.controller;

import core.app.like.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping//HTTP POST 요처으로 사용자 id와 질문 id를 전송하면 질문글에 대한 좋아요 정보를 like 모델 클래스에 저장함.
    public void likePost(@RequestParam Long memberId,
                         @RequestParam Long questionId){
        likeService.likePost(memberId,questionId);
    }

    @DeleteMapping//HTTP DELETE 요청으로 사용자 id와 질문 id를 전송하면 질문글에 대한 좋아요 정보를 like 모델 클래스에서 삭제함.
    public void unlikePost(@RequestParam Long memberId,
                           @RequestParam Long questionId){
        likeService.unlikePost(memberId,questionId);
    }

    @GetMapping("/{questionId}/likes/count") //GET 요청으로 여기 경로에다가 요청 보내면 해당 질문글에 대한 좋아요 개수 반환.
    public long getLikeCountByQuestionId(@PathVariable Long questionId){
        return likeService.getLikeCountByQuestionId(questionId);
    }


}
