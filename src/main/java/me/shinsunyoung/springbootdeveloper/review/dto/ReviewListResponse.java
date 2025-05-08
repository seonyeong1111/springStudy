package me.shinsunyoung.springbootdeveloper.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class ReviewListResponse {
    @Builder
    @Getter
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {

        List<ReviewPreViewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements; //총 데이터 수
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @AllArgsConstructor
    public static class ReviewPreViewDTO {

        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }
}
