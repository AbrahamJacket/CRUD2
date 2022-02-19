package com.example.crud2.service;

import com.example.crud2.entity.Player;
import com.example.crud2.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player savePlayer(Player player){
        return playerRepository.save(player);
    }

    public Player findPlayerById(Long id){
        return playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with id = " + id));
    }

    public List<Player> findAllPlayer(){
        return playerRepository.findAll();
    }

    public Player updatePlayer(Player player, Long id){
        return playerRepository.findById(id)
                .map(entity -> {
                    entity.setFirstName(player.getFirstName());
                    entity.setLastName(player.getLastName());
                    entity.setAge(player.getAge());
                    entity.setTeam(player.getTeam());
                    return playerRepository.save(entity);
                }).orElseThrow(() -> new EntityNotFoundException("Player not found with id = " + id));
    }

    public void removePlayerById(Long id){
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with id = " + id));
        playerRepository.delete(player);
    }

    public void removeAllPlayer(){
        playerRepository.deleteAll();
    }
}
