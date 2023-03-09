package com.example.demo.controller;

import com.example.demo.dto.FavoriteDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FavoriteController {
    @GetMapping("/favorite")
    public ModelAndView showFavorite(@SessionAttribute(name = "favorite") FavoriteDto favoriteDto) {
        return new ModelAndView("favorite/list", "favorite", favoriteDto);
    }
}
