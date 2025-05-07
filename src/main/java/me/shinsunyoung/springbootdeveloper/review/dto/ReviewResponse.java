package me.shinsunyoung.springbootdeveloper.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class ReviewResponse {

    private Long reviewId;

    private String text;

    private Float score;

    private Long memberId;

    private Long storeId;

    private LocalDateTime createdAt;

}
