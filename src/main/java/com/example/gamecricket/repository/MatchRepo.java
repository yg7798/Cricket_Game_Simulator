package com.example.gamecricket.repository;

import com.example.gamecricket.entities.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepo extends CrudRepository<Match,Integer> {

}
