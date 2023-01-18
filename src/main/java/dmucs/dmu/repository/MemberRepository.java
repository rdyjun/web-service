package dmucs.dmu.repository;

import dmucs.dmu.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(String studentId);
    Optional<Member> findByPhone(String phone);
    Optional<Member> findByEmail(String email);
    List<Member> findAll();
    Member drop(Member member);
}
