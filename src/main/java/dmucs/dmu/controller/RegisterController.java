package dmucs.dmu.controller;

import dmucs.dmu.SpringConfig;
import dmucs.dmu.member.Member;
import dmucs.dmu.member.MemberDao;
import dmucs.dmu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private MemberService memberService;
    MemberDao memberDao;

    @PostMapping("/create")
    public String register (@RequestBody Member member) {
        memberService.join(member);
        return memberService.findMember(member.getStudentId()).get().toString();
    }
}
