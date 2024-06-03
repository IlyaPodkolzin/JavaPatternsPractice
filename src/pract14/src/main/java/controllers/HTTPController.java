package pract14.src.main.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTTPController {

    @GetMapping("/home")
    public String home() {
        return "index";
    }
}
