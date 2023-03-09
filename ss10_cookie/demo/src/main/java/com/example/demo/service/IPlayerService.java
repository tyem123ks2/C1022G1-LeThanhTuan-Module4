package com.example.demo.service;

import com.example.demo.model.Player;
import java.util.List;
import java.util.Optional;

public interface IPlayerService {
    List<Player> findAll();

    Optional<Player> findById(int id);
}
