package me.shinsunyoung.springbootdeveloper.global.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import me.shinsunyoung.springbootdeveloper.global.validation.validator.ExistMissionIdValidator;
import me.shinsunyoung.springbootdeveloper.global.validation.validator.ExistStoreIdValidator2;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistMissionIdValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMissionId {

    String message() default "해당하는 missionId가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

