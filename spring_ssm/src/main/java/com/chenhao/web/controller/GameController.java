package com.chenhao.web.controller;

import com.chenhao.domain.Game;
import com.chenhao.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/4 14:38
 */
@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/{id}")
    public String findById(@PathVariable Integer id){
        Game game = gameService.findById(id);
        return game.toString();
    }
}
