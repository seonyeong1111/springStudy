package me.shinsunyoung.springbootdeveloper.domain.mapping;

import lombok.*;

@NoArgsConstructor //public
@AllArgsConstructor
@Builder
@Getter
public class UpdateMMRequestDto {

    private Long memberId;

    private Long missionId;

    private MissionStatus missionStatus;

}
