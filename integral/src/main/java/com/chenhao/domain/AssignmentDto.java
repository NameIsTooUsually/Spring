package com.chenhao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/7 15:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentDto {
    private String name;
    private String memo;
    private Integer type;
    private Date createdOn;


}
