package me.shinsunyoung.springbootdeveloper.global.validation.validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.code.BaseErrorCode;

public abstract class AbstractExistIdValidator<A extends java.lang.annotation.Annotation>
        implements ConstraintValidator<A, Long> {

    protected abstract BaseErrorCode getErrorStatus();

    protected abstract boolean isExist(Long id);

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        boolean isValid = isExist(id);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context
                    .buildConstraintViolationWithTemplate("왜 안되노")
                    .addConstraintViolation();
        }

        return isValid;
    }
}
