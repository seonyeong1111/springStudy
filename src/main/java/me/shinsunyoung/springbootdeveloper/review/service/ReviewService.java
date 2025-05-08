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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    private final StoreRepository storeRepository;

    //리뷰 추가
    public Review addReview(AddReviewRequest addReviewRequest) {

        Member member=memberRepository.findById(addReviewRequest.getMemberId()).get();
        Store store=storeRepository.findById(addReviewRequest.getStoreId()).get();

        Review newReview= ReviewConverter.toEntity(addReviewRequest);

        newReview.setMember(member);
        newReview.setStore(store);

        return reviewRepository.save(newReview);
    }

    //리뷰 목록 조회<command랑 query 분리해서 transactional(readOnly=true) 써줘야 성능 좋은데 귀찮아서 pass!
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store=storeRepository.findById(storeId).get();
        return reviewRepository.findAllByStore(store, PageRequest.of(page-1, 10));

    }
}
