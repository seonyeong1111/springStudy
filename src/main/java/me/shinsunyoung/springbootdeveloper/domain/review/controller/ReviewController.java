package me.shinsunyoung.springbootdeveloper.domain.review.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.review.converter.ReviewConverter;
import me.shinsunyoung.springbootdeveloper.domain.review.domain.Review;
import me.shinsunyoung.springbootdeveloper.domain.review.dto.AddReviewRequest;
import me.shinsunyoung.springbootdeveloper.domain.review.dto.ReviewResponse;
import me.shinsunyoung.springbootdeveloper.domain.review.service.ReviewService;
import me.shinsunyoung.springbootdeveloper.domain.todoList.domain.TodoList;
import me.shinsunyoung.springbootdeveloper.domain.todoList.dto.AddTodoRequest;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.ApiResponse;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.code.status.SuccessStatus;
import me.shinsunyoung.springbootdeveloper.global.validation.annotation.ExistStoreId;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/reviews")
    @CrossOrigin(origins = "http://localhost:5173")
    public ApiResponse<ReviewResponse> addReview(@Valid @RequestBody AddReviewRequest addReviewRequest) {
       Review savedReview= reviewService.addReview(addReviewRequest);

        return ApiResponse.of(ReviewConverter.toDto(savedReview),SuccessStatus._CREATED);
    }


}
