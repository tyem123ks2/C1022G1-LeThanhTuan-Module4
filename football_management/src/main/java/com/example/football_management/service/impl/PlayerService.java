package com.example.football_management.service.impl;

import com.example.football_management.model.Player;
import com.example.football_management.repository.IPlayerRepository;
import com.example.football_management.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository playerRepository;

    @Override
    public Page<Player> searchName(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Player> searchName(String name, String position, Pageable pageable) {
        return null;
    }

    @Override
    public List<Player> getAllPlayer() {
        return null;
    }

    @Override
    public boolean getAddNewPlayer(Player player) {
        return false;
    }

    @Override
    public boolean editPlayer(Player player) {
        return false;
    }

    @Override
    public boolean deletePlayer(Player player) {
        return false;
    }

    @Override
    public Player findById(Long id) {
        return null;
    }
}