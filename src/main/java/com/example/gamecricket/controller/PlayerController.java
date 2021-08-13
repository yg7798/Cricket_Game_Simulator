package com.example.gamecricket.controller;

import com.example.gamecricket.entities.Player;
import com.example.gamecricket.exception.NotFoundException;
import com.example.gamecricket.request_dto.PlayerRequest;
import com.example.gamecricket.response_dto.BaseResponse;
import com.example.gamecricket.response_dto.PlayerSummary;
import com.example.gamecricket.services.PlayerService;
import com.example.gamecricket.services.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers()
    {
        return playerService.getAllPlayers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse createPlayer(@Valid @RequestBody PlayerRequest playerRequest)
    {
        return playerService.createPlayer(playerRequest);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public BaseResponse updatePlayer(@RequestBody Player player,@PathVariable int id)
    {
        return playerService.updatePlayer(id,player);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable int id)
    {
        Player player=playerService.getPlayer(id);
        if(player.getPlayerID()==0)
        {
            throw new NotFoundException("PlayerId "+id+" NOT FOUND");
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/{id}")
    public BaseResponse deletePlayer(@PathVariable int id)
    {
       return playerService.deletePlayer(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/list")
    public BaseResponse createPlayers(@RequestBody List<Player> players)
    {
       return playerService.createListPlayers(players);
    }

    @GetMapping("/summary/{matchNumber}/{inningsNumber}")
    public PlayerSummary getPlayersSummary(@PathVariable int matchNumber, @PathVariable int inningsNumber) {
        return  playerService.setPlayerSummaryForMatch(matchNumber, inningsNumber);
    }
}
