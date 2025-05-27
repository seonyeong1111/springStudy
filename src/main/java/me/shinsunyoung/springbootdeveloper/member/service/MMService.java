package me.shinsunyoung.springbootdeveloper.member.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.member.dto.req.AddMMRequestDto;
import me.shinsunyoung.springbootdeveloper.member.repository.MMRepository;
import me.shinsunyoung.springbootdeveloper.member.domain.MemberMission;
import me.shinsunyoung.springbootdeveloper.member.domain.enums.MissionStatus;
import me.shinsunyoung.springbootdeveloper.member.domain.Member;
import me.shinsunyoung.springbootdeveloper.member.repository.MemberRepository;
import me.shinsunyoung.springbootdeveloper.mission.domain.Mission;
import me.shinsunyoung.springbootdeveloper.mission.repository.MissionRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MMService {

    private final MMRepository mmRepository;

    private final MemberRepository memberRepository;

    private final MissionRepository missionRepository;

    public MemberMission addMM(AddMMRequestDto addMMRequestDto){

        Member member= memberRepository.findById(addMMRequestDto.getMemberId()).get();
        Mission mission= missionRepository.findById(addMMRequestDto.getMissionId()).get();

        MemberMission newMM=addMMRequestDto.toEntity();

        newMM.setMember(member);
        newMM.setMission(mission);

        return mmRepository.save(newMM);
    }

    public boolean existsByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus status){
        return mmRepository.existsByMemberIdAndMissionIdAndMissionStatus(memberId,missionId,status);
    }


    public void findMm (){
        MemberMission mm = mmRepository.findByMemberIdAndMissionId(1L,2L);
    }
}
