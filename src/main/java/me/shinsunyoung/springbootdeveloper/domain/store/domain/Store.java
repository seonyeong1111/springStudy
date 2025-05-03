package me.shinsunyoung.springbootdeveloper.domain.store.domain;

import jakarta.persistence.*;
import lombok.*;
import me.shinsunyoung.springbootdeveloper.domain.member.domain.Member;
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

    @OneToMany(mappedBy = "review",cascade = CascadeType.ALL)
    private List<Store> storeList=new ArrayList<>();

    @Builder
    public Store(String name, String address, Float score) {
        this.name = name;
        this.address = address;
        this.score = score;
    }


}
