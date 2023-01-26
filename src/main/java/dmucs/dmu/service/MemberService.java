package dmucs.dmu.service;

import dmucs.dmu.SpringConfig;
import dmucs.dmu.member.Grade;
import dmucs.dmu.member.Member;
import dmucs.dmu.repository.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final JpaMemberRepository jpaMemberRepository;


    // 가입
    public void join (Member member) {
        validateDuplicateManager(member);
        jpaMemberRepository.save(member);
    }
    // 중복 확인
    public void validateDuplicateManager (Member member) {
        jpaMemberRepository.findById(member.getStudentId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 학생입니다.");
                });
    }
    public Optional<Member> findById (String studentId) {
        return jpaMemberRepository.findById(studentId);
    }
}
