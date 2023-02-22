package dmucs.dmu.controller;

import dmucs.dmu.member.Member;
import dmucs.dmu.member.MemberSigninDto;
import dmucs.dmu.service.LoginService;
import dmucs.dmu.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;


@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignController {
    private final MemberService memberService;
    private final LoginService loginService;
    private final EntityManager em;

    @PostMapping("/register")
    public String register (@RequestBody Member member) {
        memberService.join(member);
        return memberService.findByEmailId(member.getEmailId()).get() + "회원가입 성공";
    }
    @PostMapping("/login")
    public String login (@RequestBody MemberSigninDto member) {
        if(loginService.login(member))
            return "redirect:/";
        return "login";
    }
}
