package me.shinsunyoung.springbootdeveloper.mission.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.mission.repository.MissionRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MissionService {

    private final MissionRepository missionRepository;
    public boolean existsById(Long missionId) {
        return missionRepository.existsById(missionId);
    }
}
