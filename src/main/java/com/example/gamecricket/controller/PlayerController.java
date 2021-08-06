package com.example.gamecricket.controller;

import com.example.gamecricket.entities.Player;
import com.example.gamecricket.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<Player> getAllPlayers()
    {
        return playerService.getAllPlayers();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/players")
    public void createPlayer(@RequestBody Player player)
    {
        playerService.createPlayer(player);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/players/{id}")
    public void updatePlayer(@RequestBody Player player,@PathVariable int id)
    {
        playerService.updatePlayer(id,player);
    }

    @RequestMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id)
    {
        return playerService.getPlayer(id);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/players/{id}")
    public void deletePlayer(@PathVariable int id)
    {
        playerService.deletePlayer(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/players/list")
    public void createPlayers(@RequestBody List<Player> players)
    {
        playerService.createListPlayers(players);
    }

}
