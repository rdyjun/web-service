package dmucs.dmu.service;

import dmucs.dmu.bcrypt.EncryptHelper;
import dmucs.dmu.member.Member;
import dmucs.dmu.repository.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final JpaMemberRepository jpaMemberRepository;
    private final EncryptHelper encryptHelper;

    // 가입
    public void join (Member member) {
        Member m = new Member(member, encryptHelper.encrypt(member.getMemberPassword()));
        validateDuplicateManager(m);
        jpaMemberRepository.save(m);
    }

    // 중복 확인
    public void validateDuplicateManager (Member member) {
        jpaMemberRepository.findByEmailId(member.getEmailId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 학생입니다.");
                });
    }
    public Optional<Member> findByEmailId (String EmailId) {
        return jpaMemberRepository.findByEmailId(EmailId);
    }
}
