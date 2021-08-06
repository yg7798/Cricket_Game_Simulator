package com.example.gamecricket.repository;

import com.example.gamecricket.entities.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepo extends CrudRepository<Player, Integer> {
}
