package me.shinsunyoung.springbootdeveloper.apiPayload.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.BaseErrorCode;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.ErrorReasonDto;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{
    private BaseErrorCode code;
    public ErrorReasonDto getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
