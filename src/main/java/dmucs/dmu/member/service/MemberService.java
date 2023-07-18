package dmucs.dmu.member.service;

import dmucs.dmu.member.entity.Member;
import dmucs.dmu.member.entity.dto.MemberDTO;
import dmucs.dmu.member.repository.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final JpaMemberRepository jpaMemberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // 가입
    public void join (MemberDTO member) {
        Member m = new Member(member, bCryptPasswordEncoder.encode(member.getMemberPassword()));
        validateDuplicateManager(m);
        jpaMemberRepository.save(m);
    }

    // 중복 확인
    public void validateDuplicateManager (Member member) {
        jpaMemberRepository.findByEmailId(member.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    public Optional<Member> findByEmailId (String EmailId) {
        return jpaMemberRepository.findByEmailId(EmailId);
    }
    public boolean isMemberPresent (Long memberId) {
        return !jpaMemberRepository.findById(memberId).isEmpty();
    }
}
