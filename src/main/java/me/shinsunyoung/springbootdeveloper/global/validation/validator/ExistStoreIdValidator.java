package me.shinsunyoung.springbootdeveloper.global.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.store.service.StoreService;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.code.status.ErrorStatus;
import me.shinsunyoung.springbootdeveloper.global.validation.annotation.ExistStoreId;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistStoreIdValidator implements ConstraintValidator<ExistStoreId, Long> {

    private final StoreService storeService;

    @Override
    public void initialize(ExistStoreId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        boolean isValid =storeService.existsById(storeId);
        if(!isValid) {

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus._TODO_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}

