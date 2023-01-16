package dmucs.dmu.controller;

import dmucs.dmu.member.Member;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@CrossOrigin(origins = "<http://localhost:8080>") //cors 405 해결 코드
@RestController
@RequestMapping("/register")
public class RegisterController {

//    @PostMapping("/create")
//    public String register (@RequestParam Member member) {
//        System.out.println(member.toString());
//        return member.toString();
//    }
    @PostMapping("/create")
    public String register (@RequestBody String st) {
        System.out.println(st);
        return st;
    }

}
