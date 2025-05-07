package me.shinsunyoung.springbootdeveloper.store.domain;

import jakarta.persistence.*;
import lombok.*;
import me.shinsunyoung.springbootdeveloper.review.domain.Review;
import me.shinsunyoung.springbootdeveloper.global.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private Float score;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private List<Review> reviewList=new ArrayList<>();

    @Builder
    public Store(String name, String address, Float score) {
        this.name = name;
        this.address = address;
        this.score = score;
    }




}
