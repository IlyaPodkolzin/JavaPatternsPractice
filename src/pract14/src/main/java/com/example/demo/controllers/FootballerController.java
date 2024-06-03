package pract14.src.main.java.com.example.demo.controllers;

import com.example.demo.classes.Footballer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/footballers")
public class FootballerController {
    private List<Footballer> footballers = new ArrayList<>();

    @PostMapping
    public Footballer addFootballer(@RequestBody Footballer footballer) {
        footballers.add(footballer);
        return footballer;
    }

    @GetMapping
    public List<Footballer> getFootballers() {
        return footballers;
    }

    @DeleteMapping("/{index}")
    public void deleteFootballer(@PathVariable int index) {
        if (index >= 0 && index < footballers.size()) {
            footballers.remove(index);
        }
    }
}
