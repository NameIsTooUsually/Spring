package com.chenhao.domain;

import lombok.Data;

import java.sql.Date;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/8 20:42
 */
@Data
public class WorkDto {
    private Date time;
    private Integer type;
    private Date startTime;
    private Date endTime;
    private Integer classId;


}
