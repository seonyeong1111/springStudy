package me.shinsunyoung.springbootdeveloper.domain.member.domain;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import me.shinsunyoung.springbootdeveloper.domain.member.enums.Gender;
import me.shinsunyoung.springbootdeveloper.domain.member.enums.MemberStatus;
import me.shinsunyoung.springbootdeveloper.domain.member.enums.SocialType;
import me.shinsunyoung.springbootdeveloper.domain.review.domain.Review;
import me.shinsunyoung.springbootdeveloper.global.common.BaseEntity;
import org.hibernate.annotations.ColumnDefault;

@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String specAddress;

//    기본 값인 ORDINAL을 사용하면 데이터베이스에 enum의 순서가 저장이 되는데,
//    만약 Springboot에서 enum의 순서를 바꾸게 될 경우 에러가 생기게 됩니다.
//    따라서 반드시 STRING을 사용해주세요!
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @ColumnDefault("'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private LocalDate inactiveDate;

    private String email;

    private Integer point;
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Review> reviewList=new ArrayList<>();


}
