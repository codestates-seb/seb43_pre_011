package core.app.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Valid
@RestController
@RequestMapping("/boards")
public class BoardController {

    @PostMapping
    public ResponseEntity postBoard(){
        return null;
    }

    @PatchMapping("/{board-id}")
    public ResponseEntity patchBoard(){
        return null;
    }

    @GetMapping("/{board-id}")
    public ResponseEntity getBoard(){
        return null;
    }

    @GetMapping
    public ResponseEntity getBoards(){
        return null;
    }

    @DeleteMapping("/{board-id}")
    public ResponseEntity deleteBoard(){
        return null;
    }
}
