package me.shinsunyoung.springbootdeveloper.domain.mapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.review.dto.ReviewResponse;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.ApiResponse;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.code.status.SuccessStatus;
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
