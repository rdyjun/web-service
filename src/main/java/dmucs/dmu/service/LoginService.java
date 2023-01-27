package dmucs.dmu.service;

import dmucs.dmu.bcrypt.EncryptHelper;
import dmucs.dmu.member.Member;
import dmucs.dmu.member.MemberDTO;
import dmucs.dmu.repository.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final JpaMemberRepository jpaMemberRepository;
    private final EncryptHelper encryptHelper;
    public boolean login (Member member) {
        MemberDTO loginedMember = jpaMemberRepository.findByPhone(member.getPhone()).get();
        if(loginedMember == null)
            return false;

        if (!encryptHelper.isMatch(loginedMember.getMemberPassword(), member.getMemberPassword()))
            return false;

        return true;

    }
}
