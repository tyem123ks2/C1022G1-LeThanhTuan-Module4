package com.example.demo.dto;

import java.util.HashMap;
import java.util.Map;

public class FavoriteDto {
    private int id;

    private Map<PlayerDto, Integer> playerMap = new HashMap<>();

    public Map<PlayerDto, Integer> getPlayerMap() {
        return playerMap;
    }

    public FavoriteDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setPlayerMap(Map<PlayerDto, Integer> playerMap) {
        this.playerMap = playerMap;
    }

    public void addFavoritePlayer(PlayerDto playerDto) {
        if (playerMap.containsKey(playerDto)) {
            int view = playerMap.get(playerDto);
            playerMap.put(playerDto, view + 1);
        } else {
            playerMap.put(playerDto,1);
        }
    }
}
