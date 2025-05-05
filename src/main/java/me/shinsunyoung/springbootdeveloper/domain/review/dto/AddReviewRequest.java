package me.shinsunyoung.springbootdeveloper.domain.review.dto;

import lombok.*;
import me.shinsunyoung.springbootdeveloper.global.validation.annotation.ExistStoreId;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class AddReviewRequest {

    private String text;

    private Float score;

    private Long memberId;

    @ExistStoreId
    private Long storeId;

}
