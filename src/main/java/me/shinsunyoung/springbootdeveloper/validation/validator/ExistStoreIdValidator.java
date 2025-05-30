package me.shinsunyoung.springbootdeveloper.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.store.service.StoreService;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.status.ErrorStatus;
import me.shinsunyoung.springbootdeveloper.validation.annotation.ExistStoreId;
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
            context.buildConstraintViolationWithTemplate(ErrorStatus._STORE_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}

