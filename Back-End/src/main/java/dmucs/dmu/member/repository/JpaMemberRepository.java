package dmucs.dmu.member.repository;

import dmucs.dmu.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long studentId);
    Optional<Member> findByEmail(String email);
    @Query(value = "SELECT m FROM Member m WHERE m.email IN(CONCAT(:email,'@dongyang.ac.kr'), CONCAT(:email, '@m365.dongyang.ac.kr'))")
    Optional<Member> findByEmailId(@Param("email") String email);
}
