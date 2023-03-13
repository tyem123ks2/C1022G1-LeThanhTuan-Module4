package com.example.football_management.controller;

import com.example.football_management.dto.PlayerDto;
import com.example.football_management.exception.ExceptionHandle;
import com.example.football_management.model.Player;
import com.example.football_management.service.INationService;
import com.example.football_management.service.IPlayerService;
import com.example.football_management.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/player")
public class PlayerController {
    @Autowired
    private IPlayerService playerService;

    @Autowired
    private INationService nationService;

    @Autowired
    private IPositionService positionService;

    @GetMapping("/show-list")
    public String showAllPlayer(Model model, @RequestParam(value = "searchName", defaultValue = "", required = false) String name,
                                @RequestParam(value = "searchPositionId", defaultValue = "0") int positionId,
                                @RequestParam(value = "searchNationId", defaultValue = "0") int nationId,
                                @PageableDefault(size = 10) Pageable pageable) throws Exception {
        List<Player> playerList = playerService.getAllPlayer();
        if (playerList.size() > 11){
         throw new ExceptionHandle();
        }
        model.addAttribute("playerList",playerList);
        model.addAttribute("nationList", nationService.getAllNation());
        model.addAttribute("positionList", positionService.getAllPosition());
        return "/player/list";
    }

    @GetMapping("/edit/{id}")
    public String getEditPlayer(@PathVariable int id, Model model){
        Player player = playerService.findById(id);
        PlayerDto playerDto = new PlayerDto();
        BeanUtils.copyProperties(player, playerDto);

        model.addAttribute("playerDto",playerDto);
        model.addAttribute("nationList", nationService.getAllNation());
        model.addAttribute("positionList", positionService.getAllPosition());
        return "/player/edit";
    }

    public String getUpdatePlayer(@ModelAttribute @Validated PlayerDto playerDto, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("playerDto",playerDto);
            model.addAttribute("nationList", nationService.getAllNation());
            model.addAttribute("positionList", positionService.getAllPosition());
            return "/player/edit";
        }
        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
        playerService.save(player);
        redirectAttributes.addFlashAttribute("mess","Edit successfully!");
        return "redirect:/player/show-list";
    }

}
