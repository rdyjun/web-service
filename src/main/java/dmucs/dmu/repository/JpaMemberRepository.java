package dmucs.dmu.repository;

import dmucs.dmu.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findById(String studentId);
    Optional<Member> findByEmail(String email);
    @Query(value = "SELECT m FROM Member m WHERE m.email LIKE :email%")
    Optional<Member> findByEmailId(@Param("email") String email);
}
