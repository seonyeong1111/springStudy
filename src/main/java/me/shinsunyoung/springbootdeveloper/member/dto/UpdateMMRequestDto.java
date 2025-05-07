package me.shinsunyoung.springbootdeveloper.member.dto;

import lombok.*;
import me.shinsunyoung.springbootdeveloper.member.domain.enums.MissionStatus;

@NoArgsConstructor //public
@AllArgsConstructor
@Builder
@Getter
public class UpdateMMRequestDto {

    private Long memberId;

    private Long missionId;

    private MissionStatus missionStatus;

}
