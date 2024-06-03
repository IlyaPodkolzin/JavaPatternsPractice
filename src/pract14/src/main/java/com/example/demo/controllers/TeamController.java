package pract14.src.main.java.com.example.demo.controllers;

import com.example.demo.classes.Team;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private List<Team> teams = new ArrayList<>();

    @PostMapping
    public Team addTeam(@RequestBody Team team) {
        teams.add(team);
        return team;
    }

    @GetMapping
    public List<Team> getTeams() {
        return teams;
    }

    @DeleteMapping("/{index}")
    public void deleteTeam(@PathVariable int index) {
        if (index >= 0 && index < teams.size()) {
            teams.remove(index);
        }
    }
}
