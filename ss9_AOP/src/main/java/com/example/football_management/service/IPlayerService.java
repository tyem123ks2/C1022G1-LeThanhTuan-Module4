package com.example.football_management.service;

import com.example.football_management.model.Player;

import java.util.List;

public interface IPlayerService {
    List<Player> getAllPlayer();

    void save (Player player);

    Player findById (int id);
}
