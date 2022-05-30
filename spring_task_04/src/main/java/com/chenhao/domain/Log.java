package com.chenhao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private Integer id;
    private String username;
    private String operation;
    private String method;
    private String params;
    private Date created;
}
