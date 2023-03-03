package dmucs.dmu.controller;

import dmucs.dmu.member.Member;
import dmucs.dmu.member.LoginDTO;
import dmucs.dmu.member.TokenInfo;
import dmucs.dmu.service.LoginService;
import dmucs.dmu.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignController {
    private final MemberService memberService;
    private final LoginService loginService;

    @PostMapping("/register")
    public String register (@RequestBody Member member) {
        memberService.join(member);
        return memberService.findByEmailId(member.getEmailId()).get() + "회원가입 성공";
    }
    @PostMapping("/login")
    public TokenInfo login (@RequestBody LoginDTO member) {
        String email = member.getEmail();
        String password = member.getMemberPassword();
        TokenInfo tokenInfo = loginService.login(email, password);
        return tokenInfo;
    }

    @PostMapping("/test")
    public String test() {
        return "success";
    }
}
