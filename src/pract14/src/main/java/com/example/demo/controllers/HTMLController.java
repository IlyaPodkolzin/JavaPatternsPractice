package pract14.src.main.java.com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTMLController {
    @GetMapping("/home")
    public String hello() {
        return "index";
    }
}
