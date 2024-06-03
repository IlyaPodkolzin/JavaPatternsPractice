package java.org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.org.example.services.BackupService;

@Controller
@RequiredArgsConstructor
public class BackupController {

    private final BackupService backupService;

    @RequestMapping(value = "/backup")
    public String backup() {
        backupService.backup();
        return "redirect:/home";
    }
}
