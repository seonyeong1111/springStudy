package me.shinsunyoung.springbootdeveloper.review.dto;

import lombok.*;
import me.shinsunyoung.springbootdeveloper.validation.annotation.ExistStoreId;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor //아 세터 안 써주니까
@Getter
@Builder
public class AddReviewRequest {

    private String text;

    private Float score;

    private Long memberId;

    @ExistStoreId
    private Long storeId;

}
