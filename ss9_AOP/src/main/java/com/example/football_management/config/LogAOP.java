package com.example.football_management.config;

import com.example.football_management.dto.PlayerDto;
import com.example.football_management.model.Player;
import com.example.football_management.service.impl.PlayerService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class LogAOP {
    @Autowired
    private PlayerService playerService;

    @Pointcut("execution(* com.example.football_management.controller.PlayerController.getUpdatePlayer(..))&&args(playerDto,*,*,*)")
    public void getAllUpdate(PlayerDto playerDto) {
    }

    @After(value = "getAllUpdate(playerDto)", argNames = "playerDto")
    public void printUpdate(PlayerDto playerDto) {
        List<Player> playerList = playerService.getAllPlayer();
        int count = 0;
        for (Player player : playerList) {
            if (player.isStatus() == true) {
                count++;
            }
        }

        System.out.println("Cầu thủ" + playerDto.getName() + "chuyển đổi thành " + playerDto.isStatus());
        System.out.println("Số lượng đã đăng kí: " + count);
    }
}
