package me.shinsunyoung.springbootdeveloper.global.validation.validator;

import me.shinsunyoung.springbootdeveloper.mission.service.MissionService;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.code.BaseErrorCode;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.code.status.ErrorStatus;
import me.shinsunyoung.springbootdeveloper.global.validation.annotation.ExistMissionId;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExistMissionIdValidator extends AbstractExistIdValidator<ExistMissionId> {

    private final MissionService missionService;

    @Override
    protected boolean isExist(Long id) {
        return missionService.existsById(id);
    }

    protected BaseErrorCode getErrorStatus() {
        return ErrorStatus._MISSION_NOT_FOUND;
    }
}
