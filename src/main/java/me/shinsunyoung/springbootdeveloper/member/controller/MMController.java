package me.shinsunyoung.springbootdeveloper.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.member.dto.res.MMResponseDto;
import me.shinsunyoung.springbootdeveloper.member.domain.MemberMission;
import me.shinsunyoung.springbootdeveloper.apiPayload.ApiResponse;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.status.SuccessStatus;
import me.shinsunyoung.springbootdeveloper.member.dto.req.AddMMRequestDto;
import me.shinsunyoung.springbootdeveloper.member.service.MMService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MMController {

    private final MMService mmService;

    @PostMapping("missions")
    @CrossOrigin(origins = "http://localhost:5173")
    public ApiResponse<MMResponseDto> addMM(@Valid @RequestBody AddMMRequestDto addMMRequestDto){
        MemberMission mm=mmService.addMM(addMMRequestDto);
        return ApiResponse.of(mm.toDto(),SuccessStatus._CREATED);
    }
}
