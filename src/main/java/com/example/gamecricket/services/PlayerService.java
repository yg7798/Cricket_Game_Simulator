package com.example.gamecricket.services;

import com.example.gamecricket.entities.Match;
import com.example.gamecricket.entities.Player;
import com.example.gamecricket.repository.PlayerRepo;
import com.example.gamecricket.response_dto.PlayerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;


    public List<Player> getAllPlayers() {
        List<Player>players=new ArrayList<>();
        playerRepo.findAll().forEach(players::add);
        return players;
    }

    public void createPlayer(Player player) {
        playerRepo.save(player);
    }

    public void updatePlayer(int id, Player player) {
        playerRepo.save(player);
    }

    public Player getPlayer(int id) {
        Optional<Player> player = playerRepo.findById(id);
        return player.orElse(player.get());
    }

    public void createListPlayers(List<Player>players)
    {
        for(Player player:players)
        {
            playerRepo.save(player);
        }
    }
    public void deletePlayer(int id) {
        playerRepo.deleteById(id);
    }

}
