package dmucs.dmu.repository;

import dmucs.dmu.member.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

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

    @Override
    public Member drop(Member member) {
        store.remove(member);
        return member;
    }
}
