package me.shinsunyoung.springbootdeveloper.todoList.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import me.shinsunyoung.springbootdeveloper.todoList.validation.validator.ExistIdsValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistIdsValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistIds {

    String message() default "해당하는 id가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
