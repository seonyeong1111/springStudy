package me.shinsunyoung.springbootdeveloper.azure;

import com.azure.storage.blob.*;
import com.azure.storage.blob.models.*;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.status.ErrorStatus;
import me.shinsunyoung.springbootdeveloper.apiPayload.exception.GeneralException;
import me.shinsunyoung.springbootdeveloper.review.domain.Review;
import me.shinsunyoung.springbootdeveloper.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.UUID;

@Service
public class AzureBlobService {

    private final BlobContainerClient containerClient;
    private final ImageRepository imageRepository;
    private final ReviewRepository reviewRepository;

    //생성
    public AzureBlobService(
            @Value("${azure.storage.connection-string}") String connectionString,
            @Value("${azure.storage.container-name}") String containerName,
            ImageRepository imageRepository,
            ReviewRepository reviewRepository
    ) {
        BlobServiceClient serviceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();

        this.containerClient = serviceClient.getBlobContainerClient(containerName);
        this.imageRepository = imageRepository;
        this.reviewRepository = reviewRepository;
    }
    @Transactional
    public ResponseDto.UploadDto upload(MultipartFile file, Long reviewId) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new GeneralException(ErrorStatus._FILE_REQUIRED);
        }
        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
        BlobClient blobClient = containerClient.getBlobClient(fileName);
        blobClient.upload(file.getInputStream(), file.getSize(), true);

        String imageUrl = blobClient.getBlobUrl();
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new GeneralException(ErrorStatus._REVIEW_NOT_FOUND));

        Image image = new Image(imageUrl, review);
        Image savedImage = imageRepository.save(image);

        return new ResponseDto.UploadDto(savedImage.getId(), imageUrl);
    }

    public ResponseDto.UploadDto getImage(UUID imageId) {
        Image image = imageRepository.findById(imageId).orElseThrow(() -> new GeneralException(ErrorStatus._IMAGE_NOT_FOUND));
        return new ResponseDto.UploadDto(image.getId(), image.getImageUrl());
    }

    @Transactional
    public void deleteImage(UUID imageId) {
        Image image = imageRepository.findById(imageId)
                .orElseThrow(() -> new GeneralException(ErrorStatus._IMAGE_NOT_FOUND));
        imageRepository.delete(image);
        BlobClient blobClient = containerClient.getBlobClient(getFileNameFromUrl(image.getImageUrl()));
        blobClient.delete();
    }

    // getFileNameFromUrl은 private 메서드로 서비스 내부에서만 사용
    private String getFileNameFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }
}
