package me.shinsunyoung.springbootdeveloper.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.ReasonDto;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.BaseCode;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessStatus implements BaseCode {
    _OK(HttpStatus.OK,"COMMON200","성공입니다"),

    _CREATED(HttpStatus.CREATED, "COMMON201","성공적으로 생성하였습니다");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDto getReasonHttpStatus() {
        return ReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
