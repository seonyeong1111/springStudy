package me.shinsunyoung.springbootdeveloper.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import me.shinsunyoung.springbootdeveloper.member.domain.enums.MissionStatus;

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
