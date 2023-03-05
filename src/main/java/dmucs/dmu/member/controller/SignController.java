package dmucs.dmu.member.controller;

import dmucs.dmu.member.entity.Member;
import dmucs.dmu.member.entity.dto.LoginDTO;
import dmucs.dmu.security.entity.TokenInfo;
import dmucs.dmu.member.service.LoginService;
import dmucs.dmu.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


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
    @ResponseBody
    public TokenInfo login (@RequestBody LoginDTO member, HttpServletResponse response) {
        TokenInfo tokenInfo = loginService.login(member.getEmail(), member.getMemberPassword());

        ResponseCookie cookie = ResponseCookie.from("refreshToken", tokenInfo.getRefreshToken())
                .maxAge(14 * 24 * 60 * 60)
                .path("/")
                .secure(true)
                .sameSite("None")
                .httpOnly(true)
                .build();
        response.setHeader("Set-Cookie", cookie.toString());
        tokenInfo.setRefreshToken("httponly");
        return (tokenInfo);
    }

    @PostMapping("/test")
    public String test() {
        return "success";
    }
}
