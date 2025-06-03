package me.shinsunyoung.springbootdeveloper.azure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import me.shinsunyoung.springbootdeveloper.review.dto.ReviewListResponse;

import java.util.List;
import java.util.UUID;

public class ResponseDto {
    @Builder
    @Getter
    @AllArgsConstructor
    public static class UploadDto {

    UUID id;
    String imageUrl;
    }
}
