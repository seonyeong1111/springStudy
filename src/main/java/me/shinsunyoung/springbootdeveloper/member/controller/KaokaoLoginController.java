package me.shinsunyoung.springbootdeveloper.member.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.shinsunyoung.springbootdeveloper.apiPayload.ApiResponse;
import me.shinsunyoung.springbootdeveloper.member.dto.res.KakaoUserInfoResponseDto;
import me.shinsunyoung.springbootdeveloper.member.dto.res.LoginResDto;
import me.shinsunyoung.springbootdeveloper.member.service.KakaoService;
import me.shinsunyoung.springbootdeveloper.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class KaokaoLoginController {

    private final KakaoService kakaoService;
    private final MemberService memberService;

    @GetMapping("/callback")
    public ApiResponse<LoginResDto> callback(@RequestParam("code") String code, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accessToken = kakaoService.getAccessTokenFromKakao(code);

        KakaoUserInfoResponseDto userInfo = kakaoService.getUserInfo(accessToken);

        //회원가입, 로그인 동시진행
        return ApiResponse.onSuccess(memberService.kakaoLogin(request,response, memberService.kakaoSignup(userInfo)));
    }
}
