package com.example.football_management.controller;

import com.example.football_management.dto.PlayerDto;
import com.example.football_management.model.Nation;
import com.example.football_management.model.Player;
import com.example.football_management.model.Position;
import com.example.football_management.service.INationService;
import com.example.football_management.service.IPlayerService;
import com.example.football_management.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/show-list")
    public String showList(Model model, @RequestParam(value = "searchName", defaultValue = "", required = false) String name,
                           @RequestParam(value = "searchPositionId", defaultValue = "0") int positionId,
                           @RequestParam(value = "searchNationId", defaultValue = "0") int nationId,
                           @PageableDefault(size = 3) Pageable pageable) {
        Page<Player> playerList;
        playerList = playerService.searchName(name, positionId, nationId, pageable);
        PlayerDto playerDto = new PlayerDto();
        List<Nation> nationList = nationService.getAllNation();
        List<Position> positionList = positionService.getAllPosition();
        model.addAttribute("name", name);
        model.addAttribute("playerDto", playerDto);
        model.addAttribute("playerList", playerList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("positionList", positionList);
        return "/player/list";
    }

    @PostMapping(value = "/add")
    public String addNewCustomer(@Validated PlayerDto playerDto, BindingResult bindingResult, Model model,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            Pageable pageable = null;
            Page<Player> playerList = playerService.searchName("", pageable);
            List<Nation> nationList = nationService.getAllNation();
            List<Position> positionList = positionService.getAllPosition();
            model.addAttribute("PlayerDto", playerDto);
            model.addAttribute("playerList", playerList);
            model.addAttribute("nationList", nationList);
            model.addAttribute("positionList", positionList);
            model.addAttribute("hasErr", "true");
            return "/player/list";
        } else {
            Player player = new Player();
            BeanUtils.copyProperties(playerDto, player);
            boolean check = playerService.getAddNewPlayer(player);
            String mess;
            if (check) {
                mess = "Thêm mới thành công";
            } else {
                mess = "Đã xảy ra lỗi";
            }
            redirectAttributes.addFlashAttribute("mess", mess);
            return "redirect:/player/show-list";
        }
    }

    @PostMapping(value = "/edit")
    public String editCustomer(@Validated PlayerDto playerDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            Pageable pageable = null;
            Page<Player> playerList = playerService.searchName("", pageable);
            List<Nation> nationList = nationService.getAllNation();
            List<Position> positionList = positionService.getAllPosition();
            model.addAttribute("PlayerDto", playerDto);
            model.addAttribute("playerList", playerList);
            model.addAttribute("nationList", nationList);
            model.addAttribute("positionList", positionList);
            return "/player/list";
        } else {
            Player player = new Player();
            BeanUtils.copyProperties(playerDto, player);
            boolean check = playerService.getAddNewPlayer(player);
            String mess;
            if (check) {
                mess = "Thêm mới thành công";
            } else {
                mess = "Đã xảy ra lỗi";
            }
            redirectAttributes.addFlashAttribute("mess", mess);
            return "redirect:/player/show-list";
        }
    }

    @PostMapping(value = "/delete")
    public String deleteCustomer(@RequestParam int id, PlayerDto playerDto, Model model, RedirectAttributes redirectAttributes) {
        playerService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/player/show-list";
    }

}
