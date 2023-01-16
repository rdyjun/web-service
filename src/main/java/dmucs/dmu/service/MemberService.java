package dmucs.dmu.service;

import dmucs.dmu.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    void join(Member member);
    void validateDuplicateManager(Member member);
    List<Member> getMember();
    Optional<Member> findMember (String studentId);
}
