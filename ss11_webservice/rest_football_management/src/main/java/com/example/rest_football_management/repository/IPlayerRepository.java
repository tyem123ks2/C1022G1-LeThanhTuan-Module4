package com.example.rest_football_management.repository;

import com.example.rest_football_management.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerRepository extends JpaRepository<Player, Integer> {
}
