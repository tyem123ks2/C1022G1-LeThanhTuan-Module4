package com.example.rest_football_management.repository;

import com.example.rest_football_management.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
}
