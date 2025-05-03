package me.shinsunyoung.springbootdeveloper.domain.todoList.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.code.status.ErrorStatus;
import me.shinsunyoung.springbootdeveloper.domain.todoList.service.TodoListService;
import me.shinsunyoung.springbootdeveloper.domain.todoList.validation.annotation.ExistIds;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistIdsValidator implements ConstraintValidator<ExistIds,Long> {

    private final TodoListService todoListService;

    @Override
    public void initialize(ExistIds constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        boolean isValid = todoListService.existsById(id);

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus._TODO_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
