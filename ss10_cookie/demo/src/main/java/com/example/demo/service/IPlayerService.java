package com.example.demo.service;

import com.example.demo.model.Player;
import java.util.List;
import java.util.Optional;

public interface IPlayerService {
    List<Player> getAllPlayer();

    Optional<Player> findById(int id);
}

