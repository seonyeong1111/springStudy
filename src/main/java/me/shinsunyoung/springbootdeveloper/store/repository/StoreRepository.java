package me.shinsunyoung.springbootdeveloper.store.repository;

import me.shinsunyoung.springbootdeveloper.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
}
