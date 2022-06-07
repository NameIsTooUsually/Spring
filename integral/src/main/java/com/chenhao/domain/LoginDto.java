package com.chenhao.domain;

import lombok.Data;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/7 13:12
 */
@Data
public class LoginDto {
    private String name;
    private String password;
    private Integer classId;
}
