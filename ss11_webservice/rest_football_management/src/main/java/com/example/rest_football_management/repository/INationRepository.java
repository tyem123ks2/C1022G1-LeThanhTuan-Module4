package com.example.rest_football_management.repository;

import com.example.rest_football_management.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INationRepository extends JpaRepository<Nation, Integer> {
}
