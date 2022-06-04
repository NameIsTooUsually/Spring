package com.chenhao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/4 10:15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private Integer id;
    private String name;
    private String type;
    private String url;
    private String ordered;
    private String company;
}
