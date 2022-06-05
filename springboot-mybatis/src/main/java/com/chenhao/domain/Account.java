package com.chenhao.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/5 10:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_account")
public class Account {
    private Long id;
    private String username;
    @TableField(select = false)
    private Double money;
    @TableField(exist = false)
    private Integer status;
}
