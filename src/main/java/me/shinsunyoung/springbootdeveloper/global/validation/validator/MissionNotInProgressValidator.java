package me.shinsunyoung.springbootdeveloper.global.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.member.dto.AddMMRequestDto;
import me.shinsunyoung.springbootdeveloper.member.service.MMService;
import me.shinsunyoung.springbootdeveloper.member.domain.enums.MissionStatus;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.code.status.ErrorStatus;
import me.shinsunyoung.springbootdeveloper.global.validation.annotation.MissionNotInProgress;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionNotInProgressValidator implements ConstraintValidator<MissionNotInProgress, AddMMRequestDto> {//검증 대상의 타입

    private final MMService mmService;

    @Override
    public void initialize(MissionNotInProgress constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AddMMRequestDto request, ConstraintValidatorContext context) {
        boolean isValid=!(mmService.existsByMemberIdAndMissionIdAndStatus(request.getMemberId(), request.getMissionId(), MissionStatus.IN_PROGRESS));

        if(!isValid) {

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus._MISSION_ALREADY_IN_PROGRESS.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
