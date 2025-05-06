package me.shinsunyoung.springbootdeveloper.domain.mapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class MMResponseDto
{
    private Long id;

    private Long memberId;

    private Long missionId;

    private MissionStatus missionStatus;

    private LocalDateTime createdAt;

}
