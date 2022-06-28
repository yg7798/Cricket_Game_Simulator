package com.example.gamecricket.services;

import com.example.gamecricket.entities.Ball;
import com.example.gamecricket.repository.BallRepo;
import com.example.gamecricket.response_dto.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class BallServiceImpl implements BallService {
    @Autowired
    private BallRepo ballRepo;

    @Override
    public List<Ball> getAllBalls() {
        List<Ball>balls=new ArrayList<>();
        ballRepo.findAll().forEach(balls::add);
        return balls;
    }

    @Override
    public BaseResponse createBall(Ball ball) {
        ballRepo.save(ball);
        return new BaseResponse(true,"ball added successfully",ball);
    }

    @Override
    public BaseResponse updateBall(int id, Ball ball) {
        ballRepo.save(ball);
        return new BaseResponse(true,"ball updated successfully",ball);
    }

    @Override
    public BaseResponse deleteBall(int id) {
        ballRepo.deleteById(id);
        return new BaseResponse(true,"ball deleted successfully",null);
    }

    @Override
    public Ball getBall(int id) {
        Optional<Ball> ball=ballRepo.findById(id);
        return ball.orElseGet(Ball::new);
    }

    @Override
    public List<Ball> getBallsByMatchNumberAndInningsNumber(int matchNumber, int inningsNumber) {
        return ballRepo.findByMatchNoAndInningsNo(matchNumber, inningsNumber);
    }

}
