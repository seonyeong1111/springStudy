package me.shinsunyoung.springbootdeveloper.mission.repository;

import me.shinsunyoung.springbootdeveloper.mission.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MissionRepository extends JpaRepository<Mission,Long> {

}
