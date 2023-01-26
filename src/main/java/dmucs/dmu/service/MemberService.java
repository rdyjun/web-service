package dmucs.dmu.service;

import dmucs.dmu.bcrypt.EncryptHelper;
import dmucs.dmu.bcrypt.SaltEncrypt;
import dmucs.dmu.member.Member;
import dmucs.dmu.repository.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final JpaMemberRepository jpaMemberRepository;
    private final EncryptHelper encryptHelper;

    // 가입
    public void join (Member member) {
        String memberPw = member.getMemberPassword();
        String encryptPw = encryptHelper.encrypt(memberPw);
        member.setMemberPassword(encryptPw);
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
