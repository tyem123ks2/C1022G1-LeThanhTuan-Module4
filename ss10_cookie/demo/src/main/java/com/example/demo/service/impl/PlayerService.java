package com.example.demo.service.impl;

import com.example.demo.model.Player;
import com.example.demo.repository.IPlayerRepository;
import com.example.demo.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository iPlayerRepository;

    @Override
    public List<Player> getAllPlayer() {
        return iPlayerRepository.findAll();
    }

    @Override
    public Optional<Player> findById(int id) {
             return iPlayerRepository.findById(id);
        }
}
