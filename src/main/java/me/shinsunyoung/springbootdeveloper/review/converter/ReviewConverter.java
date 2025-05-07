package me.shinsunyoung.springbootdeveloper.review.converter;

import me.shinsunyoung.springbootdeveloper.review.domain.Review;
import me.shinsunyoung.springbootdeveloper.review.dto.AddReviewRequest;
import me.shinsunyoung.springbootdeveloper.review.dto.ReviewResponse;

public class ReviewConverter {

    public static Review toEntity(AddReviewRequest addReviewRequest) {
    return Review.builder()
            .score(addReviewRequest.getScore())
            .text(addReviewRequest.getText())
            .build();
    }

    public static ReviewResponse toDto(Review review){
        return ReviewResponse.builder()
                .reviewId(review.getId())
                .score(review.getScore())
                .text(review.getText())
                .memberId(review.getMember().getId())
                .storeId(review.getStore().getId())
                .build();
    }
}
