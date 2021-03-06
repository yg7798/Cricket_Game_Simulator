package com.example.gamecricket.repository;

import com.example.gamecricket.entities.Ball;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BallRepo extends CrudRepository<Ball,Integer> {

    List<Ball> findByMatchNoAndInningsNo(int matchNo, int inningsNo);
}
