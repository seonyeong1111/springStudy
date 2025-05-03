package me.shinsunyoung.springbootdeveloper.domain.mapping;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.*;
import me.shinsunyoung.springbootdeveloper.domain.member.domain.Member;
import me.shinsunyoung.springbootdeveloper.domain.mission.domain.Mission;
import me.shinsunyoung.springbootdeveloper.domain.store.domain.Store;
import me.shinsunyoung.springbootdeveloper.global.common.BaseEntity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mission_id")
    private Mission mission;

    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;

}
