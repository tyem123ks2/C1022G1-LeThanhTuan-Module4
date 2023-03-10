package com.example.rest_football_management.service.impl;

import com.example.rest_football_management.model.Player;
import com.example.rest_football_management.repository.IPlayerRepository;
import com.example.rest_football_management.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository playerRepository;


    @Override
    public List<Player> getAllPlayer() {
        return playerRepository.findAll();
    }

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Player findById(int id) {
        return playerRepository.findById(id).get();
    }
}
