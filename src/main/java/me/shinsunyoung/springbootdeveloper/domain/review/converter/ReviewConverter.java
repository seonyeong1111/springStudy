package me.shinsunyoung.springbootdeveloper.domain.review.converter;

import me.shinsunyoung.springbootdeveloper.domain.member.domain.Member;
import me.shinsunyoung.springbootdeveloper.domain.review.domain.Review;
import me.shinsunyoung.springbootdeveloper.domain.review.dto.AddReviewRequest;
import me.shinsunyoung.springbootdeveloper.domain.review.dto.ReviewResponse;
import me.shinsunyoung.springbootdeveloper.domain.store.domain.Store;

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
