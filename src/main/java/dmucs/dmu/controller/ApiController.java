package dmucs.dmu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ApiController {

    @GetMapping("/api/hello")
    public String test() {
        return "Hello, world!";
    }
}
