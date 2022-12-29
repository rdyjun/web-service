package dmucs.dmu.repository;

import dmucs.dmu.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepositoryInterface {
    Member save(Member member);
    Optional<Member> findById(String studentId);
    List<Member> findAll();
}
