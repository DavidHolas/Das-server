package com.davidholas.server.services;

import com.davidholas.server.model.Player;
import com.davidholas.server.model.PlayerResource;
import com.davidholas.server.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public void addPlayer(String name) {
        Player player = new Player(name);
        playerRepository.save(player);
    }

    public void deletePlayer(Long playerId) {
        playerRepository.deleteById(playerId);
    }

    public List<Player> findAllPlayers() {
        List<Player> playerList = new ArrayList<>();
        playerRepository.findAll().forEach(playerList::add);
        return playerList;
    }

    public Player findById(Long id) {
        Optional<Player> playerOpt = playerRepository.findById(id);
        Player player = playerOpt.get();
        return player;
    }

    public void updatePlayer(PlayerResource playerResource) {
        Player player = playerRepository.getOne(playerResource.getId());

        if(player.getMoney() != playerResource.getMoney()) {
            player.setMoney(playerResource.getMoney());
        }

        if(player.getPosition() != playerResource.getPosition()) {
            player.setPosition(playerResource.getPosition());
        }

        playerRepository.save(player);
    }
}
