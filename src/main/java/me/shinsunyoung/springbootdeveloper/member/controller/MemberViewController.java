package me.shinsunyoung.springbootdeveloper.member.controller;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.member.dto.MemberRequestDto;
import me.shinsunyoung.springbootdeveloper.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberViewController {

    private final MemberService memberService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }




}
