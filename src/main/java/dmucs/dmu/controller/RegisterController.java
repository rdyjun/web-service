package dmucs.dmu.controller;

import dmucs.dmu.member.Member;
import dmucs.dmu.repository.JpaMemberRepository;
import dmucs.dmu.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/register")
public class RegisterController {
    private MemberService memberService;

    @PostMapping("/create")
    public String register (@RequestBody Member member) {
        memberService.join(member);
        return memberService.findById(member.getStudentId()).get().toString();
    }
}
