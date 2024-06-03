package java.org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.org.example.models.User;
import java.org.example.services.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/login")
public class AuthController {
    private final UserService userService;

    @GetMapping
    @ResponseBody
    public boolean login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/registration")
    @ResponseBody
    public void registration(@RequestBody User user) {
        userService.saveUser(user);
    }
}
