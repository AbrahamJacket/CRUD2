package com.example.crud2.controller;

import com.example.crud2.entity.Player;
import com.example.crud2.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/players")
    @ResponseStatus(HttpStatus.CREATED)
    public Player savePlayer(@RequestBody Player player){
        return playerService.savePlayer(player);
    }

    @GetMapping("/players/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Player findPlayerById(@PathVariable Long id){
        return playerService.findPlayerById(id);
    }

    @GetMapping("/players")
    @ResponseStatus(HttpStatus.OK)
    public List<Player> findAllPlayer(){
        return playerService.findAllPlayer();
    }

    @PutMapping("/player/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Player updatePlayer(@RequestBody Player player, @PathVariable Long id){
        return playerService.updatePlayer(player, id);
    }

    @DeleteMapping("/players/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePlayerById(@PathVariable Long id){
        playerService.removePlayerById(id);
    }

    @DeleteMapping("/players")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllPlayer(){
        playerService.removeAllPlayer();
    }
}
