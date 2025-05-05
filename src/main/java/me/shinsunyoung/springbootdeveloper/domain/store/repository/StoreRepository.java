package me.shinsunyoung.springbootdeveloper.domain.store.repository;

import me.shinsunyoung.springbootdeveloper.domain.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
}
