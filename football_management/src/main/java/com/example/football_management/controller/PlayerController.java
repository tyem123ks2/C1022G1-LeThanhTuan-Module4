package com.example.football_management.controller;

import com.example.football_management.model.Nation;
import com.example.football_management.model.Player;
import com.example.football_management.service.INationService;
import com.example.football_management.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/player")
public class PlayerController {
    @Autowired
    private IPlayerService playerService;

    @Autowired
    private INationService nationService;

    @GetMapping(value = "/show-list")
    public String showList(Model model, @RequestParam(value = "searchName", defaultValue = "") String name,
                           @PageableDefault(size = 5) Pageable pageable) {
        List<Player> playerList;
        playerList = playerService.getAllPlayer();
        List<Nation> nationList = nationService.getAllNation();
        model.addAttribute("playerList", playerList);
        model.addAttribute("nationList", nationList);
        return "/player/list";
    }
}
