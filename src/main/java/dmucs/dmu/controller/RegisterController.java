package dmucs.dmu.controller;

import dmucs.dmu.SpringConfig;
import dmucs.dmu.member.Member;
import dmucs.dmu.member.MemberDao;
import dmucs.dmu.service.MemberService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLException;


@RestController
@RequestMapping("/register")
public class RegisterController {
    SpringConfig springConfig = new SpringConfig();
    MemberService memberService = springConfig.memberService();
    MemberDao memberDao = new MemberDao();

    @PostMapping("/create")
    public String register (@RequestBody Member member) {
        memberService.join(member);
        try {
            memberDao.add(member);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return memberService.findMember(member.getStudentId()).get().toString();
    }
}
