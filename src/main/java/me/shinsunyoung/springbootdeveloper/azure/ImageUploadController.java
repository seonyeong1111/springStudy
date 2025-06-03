package me.shinsunyoung.springbootdeveloper.azure;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.apiPayload.ApiResponse;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.status.SuccessStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/images")
public class ImageUploadController {

    private final AzureBlobService azureBlobService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<ResponseDto.UploadDto> uploadImage(@RequestParam MultipartFile file ,@RequestParam Long reviewId) throws IOException {
            ResponseDto.UploadDto image = azureBlobService.upload(file,reviewId);
        return ApiResponse.onSuccess(image);
    }

    @GetMapping("/{imageId}")
    public ApiResponse<ResponseDto.UploadDto> getImage(@PathVariable UUID imageId){
        ResponseDto.UploadDto image = azureBlobService.getImage(imageId);
        return ApiResponse.onSuccess(image);
    }

    @DeleteMapping("/{imageId}")
    public ApiResponse<Void> deleteImage(@PathVariable UUID imageId){
        azureBlobService.deleteImage(imageId);
        return ApiResponse.onSuccess(null);
    }
}

