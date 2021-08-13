package com.example.gamecricket.repository;

import com.example.gamecricket.entities.Ball;
import com.example.gamecricket.entities.TossResult;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TossRepo extends CrudRepository<TossResult,Integer> {
    TossResult findByMatchID(int matchID);
}
