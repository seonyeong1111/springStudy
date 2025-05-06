package me.shinsunyoung.springbootdeveloper.domain.mission.repository;

import me.shinsunyoung.springbootdeveloper.domain.mission.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MissionRepository extends JpaRepository<Mission,Long> {

}
