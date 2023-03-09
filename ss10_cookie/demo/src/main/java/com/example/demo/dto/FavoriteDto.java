package com.example.demo.dto;

import java.util.HashMap;
import java.util.Map;

public class FavoriteDto {
    private Map<PlayerDto, Integer> playerMap = new HashMap<>();

    public FavoriteDto() {
    }

    public Map<PlayerDto, Integer> getPlayerMap() {
        return playerMap;
    }

    public void setPlayerMap(Map<PlayerDto, Integer> playerMap) {
        this.playerMap = playerMap;
    }

    public void addFavoritePlayer(PlayerDto playerDto) {
        if (playerMap.containsKey(playerDto)) {
            Integer view = playerMap.get(playerDto);
            playerMap.replace(playerDto, view +1);
        } else {
            playerMap.put(playerDto,1);
        }
    }
}
