package me.shinsunyoung.springbootdeveloper.member.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.member.converter.MemberConverter;
import me.shinsunyoung.springbootdeveloper.member.domain.Member;
import me.shinsunyoung.springbootdeveloper.member.dto.MemberRequestDto;
import me.shinsunyoung.springbootdeveloper.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService{

    private final MemberRepository memberRepository;

    public Member joinMember(MemberRequestDto.JoinDto request) {

        Member newMember = MemberConverter.toMember(request); //컨버터 위치

       return memberRepository.save(newMember);
    }

    public boolean existsById(Long memberId) {
        return memberRepository.existsById(memberId);
    }
}
