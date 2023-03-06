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
        return playerRepository.searchName(name,pageable);
    }

    @Override
    public Page<Player> searchName(String name, int positionId, int nationId, Pageable pageable) {
        return playerRepository.searchName(name, positionId, nationId, pageable);
    }



    @Override
    public List<Player> getAllPlayer() {
        return playerRepository.findAll();
    }

    @Override
    public boolean getAddNewPlayer(Player player) {
       playerRepository.save(player);
       return true;
    }

    @Override
    public boolean editPlayer(Player player) {
        playerRepository.save(player);
        return true;
    }

    @Override
    public Player findById(Long id) {
        return null;
    }
}
