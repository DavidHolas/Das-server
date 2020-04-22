package com.davidholas.server.controllers;

import com.davidholas.server.model.Player;
import com.davidholas.server.model.PlayerResource;
import com.davidholas.server.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/")
    public String showHomePage() {
        return "Home Page!";
    }

    @PostMapping("/addPlayer")
    public void addPlayer(@RequestBody String name) { playerService.addPlayer(name); }

    @DeleteMapping("/deletePlayer/{playerId}")
    public void deletePlayer(@PathVariable(name="playerId") Long playerId) { playerService.deletePlayer(playerId); }

    @GetMapping("/players")
    public List<Player> showPlayers() { return playerService.findAllPlayers(); }

    @GetMapping("/player/{playerId}")
    public Player showPlayerById(@PathVariable(name="playerId") Long playerId) { return playerService.findById(playerId); }

    @PostMapping("/updatePlayer")
    public void updatePlayer(@RequestBody PlayerResource playerResource) {
        playerService.updatePlayer(playerResource);
    }
}
