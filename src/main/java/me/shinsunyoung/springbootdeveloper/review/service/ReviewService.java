package me.shinsunyoung.springbootdeveloper.review.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.member.domain.Member;
import me.shinsunyoung.springbootdeveloper.member.repository.MemberRepository;
import me.shinsunyoung.springbootdeveloper.store.repository.StoreRepository;
import me.shinsunyoung.springbootdeveloper.store.domain.Store;
import me.shinsunyoung.springbootdeveloper.review.converter.ReviewConverter;
import me.shinsunyoung.springbootdeveloper.review.domain.Review;
import me.shinsunyoung.springbootdeveloper.review.dto.AddReviewRequest;
import me.shinsunyoung.springbootdeveloper.review.repository.ReviewRepository;
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
