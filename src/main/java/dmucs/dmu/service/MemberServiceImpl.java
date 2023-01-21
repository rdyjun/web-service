package dmucs.dmu.service;

import dmucs.dmu.member.Member;
import dmucs.dmu.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // 가입
    public void join (Member member) {
        validateDuplicateManager(member);
        memberRepository.save(member);
    }
    // 중복 확인
    public void validateDuplicateManager (Member member) {
        memberRepository.findById(member.getStudentId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 학생입니다.");
                });
    }
    public List<Member> getMember () {
        return memberRepository.findAll();
    }
    public Optional<Member> findMember (String studentId) {
        return memberRepository.findById(studentId);
    }
}
