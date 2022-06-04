package com.chenhao.service.impl;

import com.chenhao.dao.GameDao;
import com.chenhao.domain.Game;
import com.chenhao.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/4 10:46
 */
@Service
public class GameServiceImpl  implements GameService {

    @Autowired
    private GameDao gameDao;
    @Override
    public Game findById(Integer id) {
        Game game = gameDao.findById(id);
        return game;
    }
}
