package me.shinsunyoung.springbootdeveloper.validation.validator;

import me.shinsunyoung.springbootdeveloper.store.service.StoreService;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.BaseErrorCode;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.status.ErrorStatus;
import me.shinsunyoung.springbootdeveloper.validation.annotation.ExistStoreId;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExistStoreIdValidator2 extends AbstractExistIdValidator<ExistStoreId> {

    private final StoreService storeService;

    @Override
    protected boolean isExist(Long id) {
        return storeService.existsById(id);
    }

    protected BaseErrorCode getErrorStatus() {
        return ErrorStatus._STORE_NOT_FOUND;
    }
}

