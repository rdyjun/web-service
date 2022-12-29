package dmucs.dmu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlMapping {
    @GetMapping("register")
    public String register () {

        return "register";
    }
}
