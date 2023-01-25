package dmucs.dmu.repository;

import dmucs.dmu.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, String>, MemberRepository {

    Optional<Member> findById(String studentId);


}
