package com.example.football_management.service;

import com.example.football_management.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPlayerService {
    Page<Player> searchName(String name, Pageable pageable);

    Page<Player> searchName(String name, String position, Pageable pageable);

    List<Player> getAllPlayer();

    boolean getAddNewPlayer(Player player);

    boolean editPlayer(Player player);

    boolean deletePlayer(Player player);

    Player findById(Long id);
}
