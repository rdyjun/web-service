package dmucs.dmu.repository;

import dmucs.dmu.member.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<MemberDTO, String> {
    @Query("SELECT m FROM MemberDTO m WHERE m.studentId = :studentId")
    Optional<MemberDTO> findById(@Param("studentId") String studentId);

    @Query("SELECT m FROM MemberDTO m WHERE m.phone = :phone")
    Optional<MemberDTO> findByPhone(@Param("phone") String phone);
}
