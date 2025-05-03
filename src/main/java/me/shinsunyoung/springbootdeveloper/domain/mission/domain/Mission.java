package me.shinsunyoung.springbootdeveloper.domain.mission.domain;

import jakarta.persistence.*;
import lombok.*;
import me.shinsunyoung.springbootdeveloper.domain.mapping.MissionStatus;
import me.shinsunyoung.springbootdeveloper.domain.member.domain.Member;
import me.shinsunyoung.springbootdeveloper.domain.store.domain.Store;
import me.shinsunyoung.springbootdeveloper.global.common.BaseEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import me.shinsunyoung.springbootdeveloper.domain.mapping.MemberMission;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer reward;

    private LocalDate deadline;

    private String missionSpec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissonList=new ArrayList<>();
}
