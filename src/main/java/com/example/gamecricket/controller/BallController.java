package com.example.gamecricket.controller;

import com.example.gamecricket.entities.Ball;
import com.example.gamecricket.exception.NotFoundException;
import com.example.gamecricket.response_dto.BaseResponse;
import com.example.gamecricket.services.BallService;
import com.example.gamecricket.services.BallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balls")
public class BallController {
    @Autowired
    private BallService ballService;

    @GetMapping
    public List<Ball> getAllBalls()
    {
        return ballService.getAllBalls();
    }

    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse createBall(@RequestBody Ball ball)
    {
       return ballService.createBall(ball);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public BaseResponse updateBall(@RequestBody Ball ball,@PathVariable int id)
    {
        return ballService.updateBall(id,ball);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> getBall(@PathVariable int id)
    {
        Ball ball=ballService.getBall(id);
        if(ball.getBallID()==0)
        {
            throw new NotFoundException("BallID "+id+" NOT FOUND");
        }
        return new ResponseEntity<>(ball, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/{id}")
    public BaseResponse deleteBall(@PathVariable int id)
    {
        return ballService.deleteBall(id);
    }

    @GetMapping("/{matchNumber}/{inningsNumber}")
    public List<Ball> getBallsByMatchNumberAndInningsNumber(@PathVariable int matchNumber, @PathVariable int inningsNumber) {
        return ballService.getBallsByMatchNumberAndInningsNumber(matchNumber, inningsNumber);
    }
}
