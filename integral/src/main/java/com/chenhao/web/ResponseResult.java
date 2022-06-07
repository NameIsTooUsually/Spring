package com.chenhao.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/4 20:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T> {
    private Integer code;

    private String errorMessage;

    private T data;

}
