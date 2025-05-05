package me.shinsunyoung.springbootdeveloper.domain.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.member.converter.MemberConverter;
import me.shinsunyoung.springbootdeveloper.domain.member.domain.Member;
import me.shinsunyoung.springbootdeveloper.domain.member.dto.MemberRequestDto;
import me.shinsunyoung.springbootdeveloper.domain.member.dto.MemberResponseDto;
import me.shinsunyoung.springbootdeveloper.domain.member.service.MemberService;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.ApiResponse;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.code.status.SuccessStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members") //공통 경로
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDto.JoinResultDTO> join(@RequestBody @Valid MemberRequestDto.JoinDto request){
        Member savedMemeber = memberService.joinMember(request);
        return ApiResponse.of(MemberConverter.toJoinResultDTO(savedMemeber), SuccessStatus._CREATED);
    }
}
