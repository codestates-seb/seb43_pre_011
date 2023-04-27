package core.app.security.auths.controller;


import core.app.security.auths.jwt.JwtTokenizer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

//@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AuthController {
    private final JwtTokenizer jwtTokenizer;

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        //토큰을 Redis 메모리에 블랙리스트에 추가시켜서 해야함
    }
}
