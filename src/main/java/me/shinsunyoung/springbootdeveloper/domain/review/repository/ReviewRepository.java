package me.shinsunyoung.springbootdeveloper.domain.review.repository;

import me.shinsunyoung.springbootdeveloper.domain.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

}
