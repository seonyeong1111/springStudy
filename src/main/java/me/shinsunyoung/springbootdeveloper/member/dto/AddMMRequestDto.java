package me.shinsunyoung.springbootdeveloper.member.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import me.shinsunyoung.springbootdeveloper.member.domain.MemberMission;
import me.shinsunyoung.springbootdeveloper.member.domain.enums.MissionStatus;
import me.shinsunyoung.springbootdeveloper.global.validation.annotation.ExistMemberId;
import me.shinsunyoung.springbootdeveloper.global.validation.annotation.ExistMissionId;
import me.shinsunyoung.springbootdeveloper.global.validation.annotation.MissionNotInProgress;

@NoArgsConstructor //public
@AllArgsConstructor
@Builder
@Getter
@MissionNotInProgress
public class AddMMRequestDto {

    @NotNull(message = "Member ID is required.")  // null이 아니어야 함
    @ExistMemberId
    private Long memberId;

    @NotNull(message = "Mission ID is required.")  // null이 아니어야 함
    @ExistMissionId
    private Long missionId;

    private MissionStatus missionStatus;


    public MemberMission toEntity(){
        return MemberMission.builder().build();
    }

}
