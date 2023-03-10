package com.example.rest_football_management.service;

import com.example.rest_football_management.model.Player;

import java.util.List;

public interface IPlayerService {
       List<Player> getAllPlayer();

    void save(Player player);

    Player findById(int id);
}
