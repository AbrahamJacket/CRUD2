package com.example.crud2.service;

import com.example.crud2.entity.Player;
import com.example.crud2.entity.Team;
import com.example.crud2.repository.TeamRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team saveTeam(Team team){
        return teamRepository.save(team);
    }

    public Team findTeamById(Long id){
        return teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Team not found with id = " + id));
    }

    public List<Team> findAllTeam(){
        return teamRepository.findAll();
    }

    public Team updateTeam(Team team, Long id){
        return teamRepository.findById(id)
                .map(entity -> {
                    entity.setTeamName(team.getTeamName());
                    entity.setPlayers(team.getPlayers());
                    return teamRepository.save(entity);
                }).orElseThrow(() -> new EntityNotFoundException("Team not found with id = " + id));
    }

    public void removeTeamById(Long id){
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Team not found with id = " + id));
        teamRepository.delete(team);
    }

    public void removeAllTeam(){
        teamRepository.deleteAll();
    }
}
