package com.example.demo.controller;

import com.example.demo.dto.FavoriteDto;
import com.example.demo.dto.PlayerDto;
import com.example.demo.model.Player;
import com.example.demo.service.IPlayerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("favorite")
public class PlayerController {
    @Autowired
    private IPlayerService playerService;

    @ModelAttribute("favorite")
    public FavoriteDto initFavorite() {
        return new FavoriteDto();
    }

    @GetMapping("")
    public String showList(Model model) {
        List<Player> playerList = playerService.getAllPlayer();
        model.addAttribute("playerList", playerList);
        return "player/list";
    }

    @GetMapping("add/{id}")
    public String addFavorite(@PathVariable int id, @SessionAttribute("favorite") FavoriteDto favoriteDto) {
        List<Player> playerList = playerService.getAllPlayer();
        for (Player players : playerList) {
            if (playerService.findById(id).isPresent()) {
                players.setStatus(players.getStatus() + 1);
            }
        }
        Player player = playerService.findById(id).get();
        PlayerDto playerDto = new PlayerDto();
        BeanUtils.copyProperties(player, playerDto);
        favoriteDto.addFavoritePlayer(playerDto);
        Cookie cookie = new Cookie("playerId", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/favorite");
        return "redirect:/favorite";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        Optional<Player> playerList = playerService.findById(id);
        model.addAttribute("player", playerList);
        return "player/detail";
    }
}
