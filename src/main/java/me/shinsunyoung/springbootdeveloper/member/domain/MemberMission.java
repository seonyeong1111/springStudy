package me.shinsunyoung.springbootdeveloper.member.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.*;
import me.shinsunyoung.springbootdeveloper.member.domain.enums.MissionStatus;
import me.shinsunyoung.springbootdeveloper.member.dto.res.MMResponseDto;
import me.shinsunyoung.springbootdeveloper.mission.domain.Mission;
import me.shinsunyoung.springbootdeveloper.global.BaseEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@DynamicUpdate
@DynamicInsert
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //멤버는 양방향, 미션은 단방향으로 설계하자
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mission_id")
    private Mission mission;

    @ColumnDefault("'IN_PROGRESS'")
    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;

    public MMResponseDto toDto(){
        return MMResponseDto.builder()
                .id(id)
                .memberId(member.getId())
                .missionId(mission.getId())
                .missionStatus(missionStatus)
                .build();
    }

    public void setMember(Member member){
        if(this.member != null) //기존 관계 끊기
            member.getMmList().remove(this);
        this.member = member;
        member.getMmList().add(this);
    }

    public void setMission(Mission mission){
        this.mission = mission;
    }
}
