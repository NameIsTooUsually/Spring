package com.chenhao.service;

import com.chenhao.domain.Game;

public interface GameService {
    /**
     * @description:  根据id进行查询
     * @param:
     * @return:
     * @author ChenHao
     * @date: 2022/6/4 10:45
     */
    public Game findById(Integer id);

}
