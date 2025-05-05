package me.shinsunyoung.springbootdeveloper.domain.review.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.member.domain.Member;
import me.shinsunyoung.springbootdeveloper.domain.member.repository.MemberRepository;
import me.shinsunyoung.springbootdeveloper.domain.store.repository.StoreRepository;
import me.shinsunyoung.springbootdeveloper.domain.store.domain.Store;
import me.shinsunyoung.springbootdeveloper.domain.review.converter.ReviewConverter;
import me.shinsunyoung.springbootdeveloper.domain.review.domain.Review;
import me.shinsunyoung.springbootdeveloper.domain.review.dto.AddReviewRequest;
import me.shinsunyoung.springbootdeveloper.domain.review.dto.ReviewResponse;
import me.shinsunyoung.springbootdeveloper.domain.review.repository.ReviewRepository;
import me.shinsunyoung.springbootdeveloper.domain.todoList.dto.AddTodoRequest;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.ApiResponse;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.code.status.ErrorStatus;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.exception.GeneralException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    private final StoreRepository storeRepository;

    public Review addReview(AddReviewRequest addReviewRequest) {

        Member member=memberRepository.findById(addReviewRequest.getMemberId()).get();
        Store store=storeRepository.findById(addReviewRequest.getStoreId()).get();

        Review newReview= ReviewConverter.toEntity(addReviewRequest);

        newReview.setMember(member);
        newReview.setStore(store);

        return reviewRepository.save(newReview);
    }
}
