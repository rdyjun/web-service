package dmucs.dmu.controller;

import dmucs.dmu.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


// @CrossOrigin(origins = "<http://localhost:8080>") //cors 405 해결 코드
@RestController
@RequestMapping("/register")
public class RegisterController {

    @PostMapping("/create")
    public String register (@RequestBody Member member) {
        System.out.println(member.toString());
        return member.toString();
    }
}
