package dmucs.dmu.service;

import dmucs.dmu.member.Member;
import dmucs.dmu.repository.MemberRepository;
import dmucs.dmu.repository.MemberRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepositoryInterface memberRepository;

    public MemberService(MemberRepositoryInterface memberRepository){
        this.memberRepository = memberRepository;
    }


    public String join (Member member) {
        validateDuplicateManager(member);
        Member member1 = memberRepository.save(member);
        return member1.getStudentId();
    }
    public void validateDuplicateManager (Member member) {
        memberRepository.findById(member.getStudentId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 학생입니다.");
                });
    }
    public List<Member> findMember () {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne (String studentId) {
        return memberRepository.findById(studentId);
    }
}
