package dmucs.dmu.repository;

import dmucs.dmu.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findById(String studentId);

    Optional<Member> findByEmail(String email);
}
