package me.shinsunyoung.springbootdeveloper.domain.review.domain;

import jakarta.persistence.*;
import lombok.*;
import me.shinsunyoung.springbootdeveloper.domain.member.domain.Member;
import me.shinsunyoung.springbootdeveloper.domain.store.domain.Store;
import me.shinsunyoung.springbootdeveloper.global.common.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Builder
    public Review(String text, Float score, Member member,Store store) {
        this.text = text;
        this.score = score;
        this.member = member;
        this.store = store;
    }

    public void setMember(Member member){
        if(this.member != null) //기존 관계 끊기
            member.getReviewList().remove(this);
        this.member = member;
        member.getReviewList().add(this); //member의 reviewList에 현재 MemberPrefer 객체를 추가
    }

    public void setStore(Store store){
        if(this.store != null) //기존 관계 끊기
            store.getReviewList().remove(this);
        this.store=store;
        member.getReviewList().add(this); //member의 preferList에 현재 MemberPrefer 객체를 추가
    }

}
