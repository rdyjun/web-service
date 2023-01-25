package dmucs.dmu.service;

import dmucs.dmu.member.Member;
import dmucs.dmu.repository.MemberRepository;
import dmucs.dmu.repository.MemberRepositoryImpl;
import dmucs.dmu.repository.SpringDataJpaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private SpringDataJpaMemberRepository springDataJpaMemberRepository;

    @Autowired
    public MemberService(SpringDataJpaMemberRepository springDataJpaMemberRepository){
        this.springDataJpaMemberRepository = springDataJpaMemberRepository;
    }

    // 가입
    public void join (Member member) {
        validateDuplicateManager(member);
        springDataJpaMemberRepository.save(member);
    }
    // 중복 확인
    public void validateDuplicateManager (Member member) {
        springDataJpaMemberRepository.findById(member.getStudentId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 학생입니다.");
                });
    }
    public List<Member> getMember () {
        return springDataJpaMemberRepository.findAll();
    }
    public Optional<Member> findMember (String studentId) {
        return springDataJpaMemberRepository.findById(studentId);
    }
}
