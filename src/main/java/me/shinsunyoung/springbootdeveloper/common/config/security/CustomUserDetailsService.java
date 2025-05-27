package me.shinsunyoung.springbootdeveloper.common.config.security;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.status.ErrorStatus;
import me.shinsunyoung.springbootdeveloper.apiPayload.exception.GeneralException;
import me.shinsunyoung.springbootdeveloper.member.domain.Member;
import me.shinsunyoung.springbootdeveloper.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new GeneralException(ErrorStatus._MEMBER_NOT_FOUND));

        return new CustomUserDetails(member);
    }
}