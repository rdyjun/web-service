package dmucs.dmu.repository;

import dmucs.dmu.member.Member;

import java.util.*;

public class MemberRepository implements MemberRepositoryInterface {

    private static Map<String, Member> store = new HashMap<>();

    @Override
    public Member save(Member member) {
        store.put(member.getStudentId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(String studentId) {
        return Optional.ofNullable(store.get(studentId));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

}
