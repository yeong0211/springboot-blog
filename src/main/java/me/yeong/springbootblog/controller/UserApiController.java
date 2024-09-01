package me.yeong.springbootblog.controller;

import lombok.RequiredArgsConstructor;
import me.yeong.springbootblog.dto.AddUserRequest;
import me.yeong.springbootblog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request){
        userService.save(request);  //회원 가입 메서드 호출
        return "redirect:/login";   //회원 가입이 완료된 이후 로그인 페이지로 이동
    }
}
