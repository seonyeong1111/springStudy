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
}
