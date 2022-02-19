package com.example.crud2.controller;

import com.example.crud2.entity.Team;
import com.example.crud2.service.TeamService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/teams")
    @ResponseStatus(HttpStatus.CREATED)
    public Team saveTeam(@RequestBody Team team){
        return teamService.saveTeam(team);
    }

    @GetMapping("/teams/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Team findTeamById(@PathVariable Long id){
        return teamService.findTeamById(id);
    }

    @GetMapping("/teams")
    @ResponseStatus(HttpStatus.OK)
    public List<Team> findAllTeam(){
        return teamService.findAllTeam();
    }

    @PutMapping("/teams/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Team updateTeam(@RequestBody Team team, @PathVariable Long id){
        return teamService.updateTeam(team, id);
    }

    @DeleteMapping("/teams/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeTeamById(@PathVariable Long id){
        teamService.removeTeamById(id);
    }

    @DeleteMapping("/teams")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllTeam(){
        teamService.removeAllTeam();
    }
}
