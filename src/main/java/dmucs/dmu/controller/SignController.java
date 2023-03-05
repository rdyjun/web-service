package dmucs.dmu.controller;

import dmucs.dmu.member.Member;
import dmucs.dmu.member.LoginDTO;
import dmucs.dmu.jwt.TokenInfo;
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
        TokenInfo tokenInfo = loginService.login(member.getEmail(), member.getMemberPassword());
        return tokenInfo;
    }

    @PostMapping("/test")
    public String test() {
        return "success";
    }
}
