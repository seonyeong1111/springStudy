package me.shinsunyoung.springbootdeveloper.member.repository;

import me.shinsunyoung.springbootdeveloper.member.domain.MemberMission;
import me.shinsunyoung.springbootdeveloper.member.domain.enums.MissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MMRepository extends JpaRepository<MemberMission, Long> {

    boolean existsByMemberIdAndMissionIdAndMissionStatus(Long memberId, Long missionId, MissionStatus status);

    MemberMission findByMemberIdAndMissionId(Long memberId, Long missionId);

}
