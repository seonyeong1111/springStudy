package me.shinsunyoung.springbootdeveloper.store.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.store.repository.StoreRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public boolean existsById(Long storeId) {
        return storeRepository.existsById(storeId);
    }

}
