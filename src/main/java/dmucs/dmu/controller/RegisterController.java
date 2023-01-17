package dmucs.dmu.controller;

import dmucs.dmu.SpringConfig;
import dmucs.dmu.member.Member;
import dmucs.dmu.service.MemberService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@CrossOrigin(origins = "<http://localhost:8080>") //cors 405 해결 코드
@RestController
@RequestMapping("/register")
public class RegisterController {
    SpringConfig springConfig = new SpringConfig();
    MemberService memberService = springConfig.memberService();
    @PostMapping("/create")
    public String register (@RequestBody Member member) {
        memberService.join(member);
        return memberService.findMember(member.getStudentId()).get().toString();
    }
}
