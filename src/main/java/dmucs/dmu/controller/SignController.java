package dmucs.dmu.controller;

import dmucs.dmu.member.Member;
import dmucs.dmu.member.MemberSigninDto;
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
        return memberService.findById(member.getStudentId()).get().toString();
    }
    @PostMapping("/login")
    public String login (@RequestBody MemberSigninDto member) {
        if(loginService.login(member))
            return "redirect:/";
        return "login";
    }
}
