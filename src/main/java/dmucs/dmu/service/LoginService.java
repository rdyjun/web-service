package dmucs.dmu.service;

import dmucs.dmu.bcrypt.EncryptHelper;
import dmucs.dmu.member.MemberDTO;
import dmucs.dmu.member.Member;
import dmucs.dmu.member.MemberSigninDto;
import dmucs.dmu.repository.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final JpaMemberRepository jpaMemberRepository;
    private final EncryptHelper encryptHelper;
    public boolean login (MemberSigninDto member) {
        Member loginedMember = jpaMemberRepository.findByEmail(member.getEmail()).get();
        if(loginedMember == null)
            return false;

        if (!encryptHelper.isMatch(member.getMemberPassword(), loginedMember.getMemberPassword()))
            return false;

        return true;

    }
}
