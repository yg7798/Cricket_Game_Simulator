package com.example.gamecricket.services;

import com.example.gamecricket.entities.Ball;
import com.example.gamecricket.entities.Match;
import com.example.gamecricket.entities.Player;
import com.example.gamecricket.repository.BallRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BallService {
    @Autowired
    private BallRepo ballRepo;

    public List<Ball> getAllBalls() {
        List<Ball>balls=new ArrayList<>();
        ballRepo.findAll().forEach(balls::add);
        return balls;
    }

    public void createBall(Ball ball) {
        ballRepo.save(ball);
    }

    public void updateBall(int id, Ball ball) {
        ballRepo.save(ball);
    }

    public void deleteBall(int id) {
        ballRepo.deleteById(id);
    }

    public Optional<Ball> getBall(int id) {
        return ballRepo.findById(id);
    }
}
