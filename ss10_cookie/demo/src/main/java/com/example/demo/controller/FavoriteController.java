package com.example.demo.controller;

import com.example.demo.dto.FavoriteDto;
import com.example.demo.dto.PlayerDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import java.util.Map;

@Controller
public class FavoriteController {
    @GetMapping("/favorite")
    public String showFavorite(@SessionAttribute(name = "favorite") FavoriteDto favoriteDto, Model model) {
        Map<PlayerDto, Integer> playerMap = favoriteDto.getPlayerMap();
        model.addAttribute("playerMap", playerMap);
        return "favorite";
    }
}
