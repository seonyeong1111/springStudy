package me.shinsunyoung.springbootdeveloper.member.repository;

import me.shinsunyoung.springbootdeveloper.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
