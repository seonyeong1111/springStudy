package me.shinsunyoung.springbootdeveloper.review.converter;

import me.shinsunyoung.springbootdeveloper.review.domain.Review;
import me.shinsunyoung.springbootdeveloper.review.dto.AddReviewRequest;
import me.shinsunyoung.springbootdeveloper.review.dto.ReviewListResponse;
import me.shinsunyoung.springbootdeveloper.review.dto.ReviewResponse;
import org.springframework.data.domain.Page;

import java.util.List;

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

    public static ReviewListResponse.ReviewPreViewDTO toReviewPreViewDto(Review review) {
      return ReviewListResponse.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate()) //LocalDateTime과 LocalDate를 자동 변환하지 않기 때문에 에러남
                .body(review.getText())
                .build();

    }

    public static ReviewListResponse.ReviewPreViewListDTO toReviewPreViewListDto(Page<Review> reviewList) {

        List<ReviewListResponse.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewPreViewDto).toList();

        return ReviewListResponse.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();

    }
}
