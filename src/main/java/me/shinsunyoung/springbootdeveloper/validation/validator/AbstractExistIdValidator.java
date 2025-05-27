package me.shinsunyoung.springbootdeveloper.validation.validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.BaseErrorCode;

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
                    .buildConstraintViolationWithTemplate(getErrorStatus().toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
