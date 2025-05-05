package me.shinsunyoung.springbootdeveloper.domain.member.repository;

import me.shinsunyoung.springbootdeveloper.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
