package me.shinsunyoung.springbootdeveloper.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import me.shinsunyoung.springbootdeveloper.validation.validator.MissionNotInProgressValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionNotInProgressValidator.class)
@Target( {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface MissionNotInProgress {

    String message() default "이미 진행 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
