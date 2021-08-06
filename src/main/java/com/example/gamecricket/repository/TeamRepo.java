package com.example.gamecricket.repository;

import com.example.gamecricket.entities.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepo extends CrudRepository<Team,Integer> {
}
