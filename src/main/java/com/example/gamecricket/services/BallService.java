package com.example.gamecricket.services;

import com.example.gamecricket.entities.Ball;
import com.example.gamecricket.response_dto.BaseResponse;

import java.util.List;

public interface BallService {
    List<Ball> getAllBalls();
    BaseResponse createBall(Ball ball);
    BaseResponse updateBall(int id, Ball ball);
    BaseResponse deleteBall(int id);
    Ball getBall(int id);
    List<Ball> getBallsByMatchNumberAndInningsNumber(int matchNumber, int inningsNumber);
}
