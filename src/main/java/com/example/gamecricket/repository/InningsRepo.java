package com.example.gamecricket.repository;

import com.example.gamecricket.entities.Innings;
import org.springframework.data.repository.CrudRepository;

public interface InningsRepo extends CrudRepository<Innings,Integer> {
}
