package dmucs.dmu.repository;

import dmucs.dmu.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, String> {
    @Query("SELECT m FROM Member m WHERE m.studentId = :studentId")
    Optional<Member> findById(@Param("studentId") String studentId);
}
