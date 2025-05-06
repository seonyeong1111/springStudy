package me.shinsunyoung.springbootdeveloper.domain.mapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MMRepository extends JpaRepository<MemberMission,Long> {

    boolean existsByMemberIdAndMissionIdAndMissionStatus(Long memberId, Long missionId, MissionStatus status);

}
