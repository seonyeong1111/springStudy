package me.shinsunyoung.springbootdeveloper.validation.validator;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.member.service.MemberService;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.BaseErrorCode;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.status.ErrorStatus;
import me.shinsunyoung.springbootdeveloper.validation.annotation.ExistMemberId;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistMemberIdValidator extends AbstractExistIdValidator<ExistMemberId> {

    private final MemberService memberService;

    @Override
    protected boolean isExist(Long id) {
        return memberService.existsById(id);
    }

    protected BaseErrorCode getErrorStatus() {
        return ErrorStatus._MEMBER_NOT_FOUND;
    }
}