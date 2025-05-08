package me.shinsunyoung.springbootdeveloper.review.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.review.converter.ReviewConverter;
import me.shinsunyoung.springbootdeveloper.review.domain.Review;
import me.shinsunyoung.springbootdeveloper.review.dto.AddReviewRequest;
import me.shinsunyoung.springbootdeveloper.review.dto.ReviewListResponse;
import me.shinsunyoung.springbootdeveloper.review.dto.ReviewResponse;
import me.shinsunyoung.springbootdeveloper.review.service.ReviewService;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.ApiResponse;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.code.status.SuccessStatus;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/reviews")
    @CrossOrigin(origins = "http://localhost:5173")
    public ApiResponse<ReviewResponse> addReview(@Valid @RequestBody AddReviewRequest addReviewRequest) {
       Review savedReview= reviewService.addReview(addReviewRequest);

        return ApiResponse.of(ReviewConverter.toDto(savedReview),SuccessStatus._CREATED);
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")

    public ApiResponse<ReviewListResponse.ReviewPreViewListDTO> getReviewList(@PathVariable Long storeId, @RequestParam @Min(value = 1, message = "_BAD_REQUEST") @Valid Integer page){
        Page<Review> reviewList=reviewService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(ReviewConverter.toReviewPreViewListDto(reviewList));
    }



}
