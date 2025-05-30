package me.shinsunyoung.springbootdeveloper.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import me.shinsunyoung.springbootdeveloper.validation.validator.ExistMemberIdValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistMemberIdValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMemberId {

    String message() default "해당하는 memberId가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

