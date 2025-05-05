package me.shinsunyoung.springbootdeveloper.global.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import me.shinsunyoung.springbootdeveloper.domain.todoList.validation.validator.ExistIdsValidator;
import me.shinsunyoung.springbootdeveloper.global.validation.validator.ExistStoreIdValidator;
import me.shinsunyoung.springbootdeveloper.global.validation.validator.ExistStoreIdValidator2;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistStoreIdValidator2.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStoreId {

    String message() default "해당하는 storeId가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
