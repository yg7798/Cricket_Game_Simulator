package com.example.gamecricket.controller;

import com.example.gamecricket.entities.Ball;
import com.example.gamecricket.entities.Player;
import com.example.gamecricket.services.BallService;
import com.example.gamecricket.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BallController {
    @Autowired
    private BallService ballService;

    @GetMapping("/balls")
    public List<Ball> getAllBalls()
    {
        return ballService.getAllBalls();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/balls")
    public void createBall(@RequestBody Ball ball)
    {
        ballService.createBall(ball);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/balls/{id}")
    public void updateBall(@RequestBody Ball ball,@PathVariable int id)
    {
        ballService.updateBall(id,ball);
    }

    @RequestMapping("/balls/{id}")
    public Optional<Ball> getBall(@PathVariable int id)
    {
        return ballService.getBall(id);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/balls/{id}")
    public void deleteBall(@PathVariable int id)
    {
        ballService.deleteBall(id);
    }
}
