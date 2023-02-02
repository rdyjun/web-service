package dmucs.dmu.repository;

import dmucs.dmu.member.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<MemberDTO, String> {
    Optional<MemberDTO> findById(String studentId);

    Optional<MemberDTO> findByEmail(String email);
}
